package app.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
// @Order(num) 可以指定切面执行顺序，可以为多个切面指定相同顺序
@Order(1)
public class ManyAspectOne {
	@Pointcut("execution(* app.service.impl.UserServiceImpl.manyAspects(..))")
	public void manyAspects() {
		
	}
	
	@Before("manyAspects()")
	public void before() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 ManyAspectOne before.....");
	}
	
	@After("manyAspects()")
	public void after() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 ManyAspectOne after.....");
	}
	
	@AfterReturning("manyAspects()")
	public void afterReturning() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 ManyAspectOne afterRetruning.....");
	}
	@AfterThrowing("manyAspects()")
	public void afterThrowing() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 ManyAspectOne afterThrowing.....");
	}
}
