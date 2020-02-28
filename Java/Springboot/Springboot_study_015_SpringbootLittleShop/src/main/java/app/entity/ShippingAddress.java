package app.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("t_shippingaddress")
public class ShippingAddress {
	private Long id;
	private Date createTime;
	private Date updateTime;
	private String zipCode;
	// Recive address
	private String address;
	private String consignee;
	private String phone;
	private Long userId;
}
