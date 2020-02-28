package app.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("t_picture")
public class Picture {
	private Long id;
	private Date createTime;
	private Date updateTime;
	private String title;
	private String memo;
	private String url;
	private Long createAdminId;
	private Long updateAdminId;
}
