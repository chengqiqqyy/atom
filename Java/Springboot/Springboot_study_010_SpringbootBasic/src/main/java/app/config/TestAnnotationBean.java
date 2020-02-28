package app.config;

import org.springframework.context.annotation.Bean;

public class TestAnnotationBean {
	// n必须声明在 config 类中，否则即使在同一个包下也扫描不到
	@Bean
	public void testAnnnotationBean() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 Inject TestAnnotationBean to IOC");
	}
}
