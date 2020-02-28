package app.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import app.intercept.Interceptor;
import app.invoke.Invocation;

public class ProxyBean implements InvocationHandler{
	private Object target = null;
	private Interceptor interceptor = null;
	
/*	public void msg() {
		System.out.println(target.getClass().getSimpleName());
	}
	
	public void what(Object target) {
		ProxyBean pb = new ProxyBean();
		pb.target = target;
	}*/
	
	/**
	 * n绑定代理对象
	 * @param target 被代理对象
	 * @param interceptor 拦截器
	 * @return 代理对象
	 */
	public static Object getProxyBean(Object target, Interceptor interceptor) {
		ProxyBean proxyBean = new ProxyBean();
		// n保存被代理对象
		proxyBean.target = target;
		// n保存拦截器
		proxyBean.interceptor = interceptor;
		// n生成代理对象
		Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyBean);
		
		return proxy;
	}
	
	/**
	 * n处理代理对象运行逻辑
	 * @param proxy 代理对象
	 * @param method 当前方法
	 * @param args 运行参数
	 * @return 方法调用结果
	 * @throws Throwable 异常
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(target.getClass().getSimpleName());
		// n异常flag
		boolean exceptionFlag = false;
		Invocation invocation = new Invocation(args, method, target);
		Object retObj = null;
		
		try {
			if(this.interceptor.before()) {
				retObj = this.interceptor.around(invocation);
			}else {
				retObj = method.invoke(target, args);
			}
		}catch (Exception e) {
			exceptionFlag = true;
		}
		
		this.interceptor.after();
		
		if(exceptionFlag) {
			this.interceptor.afterThrowing();
		}else {
			this.interceptor.afterReturning();
			return retObj;
		}
		
		return null;
	}
	
	
}
