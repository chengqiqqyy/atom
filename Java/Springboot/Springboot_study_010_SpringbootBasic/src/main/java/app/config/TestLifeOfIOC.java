package app.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.entity.user.User;

public class TestLifeOfIOC {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(ctx.getBean(User.class).toString());
		ctx.close();
		
		
//		AnnotationConfigApplicationContext ctxBean = new AnnotationConfigApplicationContext(TestAnnotationBean.class);
//		ctxBean.getBean(TestAnnotationBean.class);
//		ctxBean.close();
	}
}
