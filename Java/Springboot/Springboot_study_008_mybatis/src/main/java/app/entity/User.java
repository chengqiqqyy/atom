package app.entity;

import lombok.Data;

@Data
public class User {
	private long id;
	private String username;
	private String password;
	private int age;
	private String sex;
	private String email;
	private int departmentCode;
}
