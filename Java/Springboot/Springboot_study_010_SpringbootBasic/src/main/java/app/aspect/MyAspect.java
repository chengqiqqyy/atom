package app.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	@Pointcut("execution(* app.service.impl.UserServiceImpl.printUser(..))")
	public void pointCut() {
		
	}
	
	@Before("pointCut()")
	public void before() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 MyAspect before........");
	}
	
	@Around("pointCut()")
	public void around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("【" + this.getClass().getSimpleName() + "】 MyAspect around before........");
		// n回调目标对象的原方法
		jp.proceed();
		System.out.println("【" + this.getClass().getSimpleName() + "】 MyAspect around after........");
	}
	
	@After("pointCut()")
	public void after() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 MyAspect after........");
	}
	
	@AfterReturning("pointCut()")
	public void afterReturning() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 MyAspect afterReturning........");
	}
	
	@AfterThrowing("pointCut()")
	public void afterThrowing() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 MyAspect afterThrowing........");
	}
}
