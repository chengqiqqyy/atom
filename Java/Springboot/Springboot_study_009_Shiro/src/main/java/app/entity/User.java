package app.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable{
	private static final long serialVersionUID = -836890658050090842L;
	
	private long id;
	private String username;
	private String password;
	private int age;
	private String sex;
	private int status;
}
