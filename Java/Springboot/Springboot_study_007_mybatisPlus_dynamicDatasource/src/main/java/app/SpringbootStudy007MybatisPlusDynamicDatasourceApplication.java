package app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("app.mapper")
public class SpringbootStudy007MybatisPlusDynamicDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStudy007MybatisPlusDynamicDatasourceApplication.class, args);
	}

}
