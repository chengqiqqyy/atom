package app.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("t_announcement")
public class Announcement {
	private Long id;
	private Date createTime;
	private Date updateTime;
	private String content;
	private Long createAdminId;
	private Long updateAdminId;
}
