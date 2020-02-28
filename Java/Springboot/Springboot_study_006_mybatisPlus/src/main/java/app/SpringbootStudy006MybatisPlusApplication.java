package app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("app.mapper")
public class SpringbootStudy006MybatisPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStudy006MybatisPlusApplication.class, args);
	}

}
