package app.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("t_producttype")
public class ProductType {
	private Long id;
	private Date createTime;
	private Date updateTime;
	private String type;
}
