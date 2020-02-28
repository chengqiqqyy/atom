package app.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("t_order")
public class Order {
	private Long id;
	private Date createTime;
	private Date updateTime;
	private String orderNumber;
	private String zipCode;
	private String address;
	private String consignee;
	private String phone;
	private double finalPrice;
	private double totalPrice;
	private Date payTime;
	private Date shipTime;
	private int status;
	private Date confirmTime;
	private Long userId;
}
