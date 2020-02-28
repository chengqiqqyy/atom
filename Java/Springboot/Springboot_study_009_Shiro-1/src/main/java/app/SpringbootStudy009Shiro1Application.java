package app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("app.mapper")
public class SpringbootStudy009Shiro1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStudy009Shiro1Application.class, args);
	}

}
