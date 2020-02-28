package app.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;

import app.service.UserValidator;
import app.service.impl.UserValidatorImpl;

@Aspect
public class MyAspect {
	
//	@DeclareParents(value = "app.service.impl.UserServiceImpl+", defaultImpl = UserValidatorImpl.class)
	// '+' symbol 代表UserServiceImpl的所有子类，但不包含自身
	@DeclareParents(value = "app.service.impl.UserServiceImpl", defaultImpl = UserValidatorImpl.class)
	public UserValidator userValidator;
	
	@Pointcut("execution(* app.service.impl.UserServiceImpl.printUser(..))")
	public void pointCut() {
		
	}
	
	@Before("pointCut()")
	public void before() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 MyAspect before....");
	}
	
	
	/**
	 * Difference between JointPoint and ProceedingJoinPoint
	 * 	If you use @before, @after-throwing, @after-returning and @after, then use Jointpoint.
	 * 	If you use @around, you should use Proceedingjoinpoint.
	 * 	They are just interface. Proceedingjoinpoint is extending Joinpoint.
	 * 
	 * More Info.
	 * 	An around advice is a special advice that can control when and if a method (or other join point) is executed.
	 * 	This is true for around advices only, so they require an argument of type 【ProceedingJoinPoint】
	 * 	whereas other advices just use a plain 【JoinPoint】
	 * 
	 * 
	 * @param jp
	 * @throws Throwable
	 */
	@Around("pointCut()")
	public void around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("【" + this.getClass().getSimpleName() + "】 MyAspect around before....");
		// n回调目标对象的原方法
		jp.proceed();
		System.out.println("【In around】 " + jp.getArgs()[0]);
		System.out.println("【" + this.getClass().getSimpleName() + "】 MyAspect around after....");
	}
	
	@After("pointCut()")
	public void after() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 MyAspect after....");
	}
	
	@AfterReturning("pointCut()")
	public void afterReturning() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 MyAspect afterReturning....");
	}
	
	@AfterThrowing("pointCut()")
	public void afterThrowing() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 MyAspect afterThrowing....");
	}
}
