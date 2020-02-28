package app.entity.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class User {
	@Value("1")
	private Long id;
	@Value("Username_02")
	private String username;
	@Value("25")
	private int age;
	@Value("This is a note.")
	private String note;
}
