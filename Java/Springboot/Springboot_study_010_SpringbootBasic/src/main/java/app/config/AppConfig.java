package app.config;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import app.aspect.MyAspect;

@Configuration
@ComponentScan(basePackages = {"app.entity"})
//@ComponentScan(basePackages = {"app.entity"}, excludeFilters = { @Filter(classes = {Service.class})})
public class AppConfig {
	@Bean
	public void TestBean() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 Inject TestAnnotationBean to IOC");
	}
	
	@Bean(name = "myAspect")
	public MyAspect initMyAspect() {
		return new MyAspect();
	}
	
	@Bean
	public String getDataSource(
			// n以JavaApplication运行时获取不到yml文件中的数据。但以SpringBootApplication启动时可以读取到yml数据。
			@Value("${testdata.driverName}") String driver,
			@Value("${testdata.url}") String url,
			@Value("${testdata.username}") String username,
			@Value("${testdata.password}") String password
			) {
		
		System.out.println("Driver: " + driver + "\nUrl: " + url + "\nUsername: " + username + "\nPassword: " + password);
		
		return "This is Annotation @Bean annotated method.";
	}
}
