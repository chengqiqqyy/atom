package app.entity;

import org.apache.ibatis.type.Alias;

import app.enumeration.SexEnum;
import lombok.Data;

@Alias(value="user")
@Data
public class User {
	private Long id;
	private String username;
	private SexEnum sex;
	private String note;
}
