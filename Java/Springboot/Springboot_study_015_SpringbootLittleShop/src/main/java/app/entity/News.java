package app.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("t_news")
public class News {
	private Long id;
	private Date createTime;
	private Date updateTime;
	private String title;
	private String content;
	private Long createUserId;
}
