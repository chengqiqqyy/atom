package app.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("product")
public class Product {
	private Long id;
	private Date createTime;
	private Date updateTime;
	private String name;
	private String model;
	private String code;
	private String note;
	private double price;
	private int stock;
	private Long productTypeId;
	private Long masterPicId;
	private Long slavePicId;
}
