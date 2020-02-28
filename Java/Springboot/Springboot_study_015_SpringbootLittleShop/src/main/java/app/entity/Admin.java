package app.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("admin")
public class Admin {
	private Long id;
	private Date createTime;
	private Date updateTime;
	private String username;
	private String password;
}
