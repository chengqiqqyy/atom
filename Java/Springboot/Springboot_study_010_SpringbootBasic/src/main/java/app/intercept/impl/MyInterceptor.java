package app.intercept.impl;

import java.lang.reflect.InvocationTargetException;

import app.intercept.Interceptor;
import app.invoke.Invocation;

public class MyInterceptor implements Interceptor{

	@Override
	public boolean before() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 MyInvocation before....");
		return true;
	}

	@Override
	public boolean useAround() {
		return true;
	}

	@Override
	public void after() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 MyInvocation after....");
	}

	@Override
	public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
		System.out.println("【" + this.getClass().getSimpleName() + "】 MyInvocation's around before....");
		Object object = invocation.proceed();
		System.out.println("【" + this.getClass().getSimpleName() + "】 MyInvocation's around after....");
		return object;
	}

	@Override
	public void afterReturning() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 MyInvocation's afterReturning....");
	}

	@Override
	public void afterThrowing() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 MyInvocation's afterThrowing....");
	}
	
	
}
