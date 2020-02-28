package app.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class ManyAspectTwo {
	@Pointcut("execution(* app.service.impl.UserServiceImpl.manyAspects(..))")
	public void manyAspects() {
		
	}
	
	@Before("manyAspects()")
	public void before() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 ManyAspectTwo before.....");
	}
	
	@After("manyAspects()")
	public void after() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 ManyAspectTwo after.....");
	}
	
	@AfterReturning("manyAspects()")
	public void afterReturning() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 ManyAspectTwo afterRetruning.....");
	}
	@AfterThrowing("manyAspects()")
	public void afterThrowing() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 ManyAspectTwo afterThrowing.....");
	}
}
