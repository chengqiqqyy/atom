package app.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("t_orderstatus")
public class OrderStatus {
	private Long id;
	private Date createTime;
	private Date updateTime;
	private String status;
}
