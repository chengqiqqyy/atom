package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import app.aspect.ManyAspectOne;
import app.aspect.ManyAspectThree;
import app.aspect.ManyAspectTwo;
import app.aspect.MyAspect;

@Configuration
public class AopConfig {
	@Bean(name = "myAspect")
	public MyAspect initMyAspect() {
		return new MyAspect();
	}
	
	@Bean(name = "manyAspectOne")
	public ManyAspectOne initMyAspectOne() {
		return new ManyAspectOne();
	} 
	
	@Bean(name = "manyAspectTwo")
	public ManyAspectTwo initMyAspectTwo() {
		return new ManyAspectTwo();
	} 
	@Bean(name = "manyAspectThree")
	public ManyAspectThree initMyAspectThree() {
		return new ManyAspectThree();
	} 
}
