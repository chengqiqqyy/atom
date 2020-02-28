package app.entity;

import lombok.Data;

@Data
public class Department {
	private long id;
	private long userId;
	private String code;
	private String name;
}
