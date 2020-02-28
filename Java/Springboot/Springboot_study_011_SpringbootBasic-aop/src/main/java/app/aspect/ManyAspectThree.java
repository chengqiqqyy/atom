package app.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class ManyAspectThree {
	@Pointcut("execution(* app.service.impl.UserServiceImpl.manyAspects(..))")
	public void manyAspects() {
		
	}
	
	@Before("manyAspects()")
	public void before() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 ManyAspectThree before.....");
	}
	
	@After("manyAspects()")
	public void after() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 ManyAspectThree after.....");
	}
	
	@AfterReturning("manyAspects()")
	public void afterReturning() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 ManyAspectThree afterRetruning.....");
	}
	@AfterThrowing("manyAspects()")
	public void afterThrowing() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 ManyAspectThree afterThrowing.....");
	}
}
