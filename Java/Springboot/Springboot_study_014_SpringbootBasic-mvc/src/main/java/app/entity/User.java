package app.entity;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("user")
@Data
public class User {
	private Long id;
	private String username;
	private String password;
}
