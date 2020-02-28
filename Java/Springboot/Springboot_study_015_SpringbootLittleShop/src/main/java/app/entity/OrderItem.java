package app.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("t_orderitem")
public class OrderItem {
	private Long id;
	private Date createTime;
	private Date updateTime;
	private int quantity;
	private Long orderId;
	private Long productId;
}
