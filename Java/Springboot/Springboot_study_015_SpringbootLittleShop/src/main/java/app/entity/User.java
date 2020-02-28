package app.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("t_user")
public class User {
	private Long id;
	private Date createTime;
	private Date updateTime;
	private String username;
	private String password;
	private int rememberMe;
	private String account;
	private String address;
	private double balance;
	private String phone;
	private int point;
	private String note;
	private String slat;
}
