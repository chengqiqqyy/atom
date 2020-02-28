package app.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable{
	private static final long serialVersionUID = -8483265212473164370L;
	
	private long id;
	private String username;
	private String password;
	private int status;
}
