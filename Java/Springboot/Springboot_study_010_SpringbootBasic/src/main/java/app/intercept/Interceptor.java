package app.intercept;

import java.lang.reflect.InvocationTargetException;

import app.invoke.Invocation;

public interface Interceptor {
	// n事前方法
	public boolean before();
	
	// n事后方法
	public void after();
	
	/**
	 *  n取代原有事件方法
	 *  @param invocation	回调参数，可以通过它的proceed方法回调原有方法
	 *  @return	原有事件返回对象
	 *  @throws InvocationTargetException
	 *  @throws IllegalAccessException
	 */
	public Object around(Invocation invocation)
		throws InvocationTargetException, IllegalAccessException;
	
	// n是否返回方法。 事件没有发生异常执行
	public void afterReturning();
	
	// n事后异常方法。 当事件发生异常后执行
	public void afterThrowing();
	
	// n是否使用around方法代替原方法
	public boolean useAround();
}
