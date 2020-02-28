package app.entity;

import java.sql.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("t_log")
public class Log {
	@TableId(value="ID")
	private Long id;
	
	@TableField(value="USERNAME")
	private String username;
	
	@TableField(value="OPERATION")
	private String operation;
	
	@TableField(value="TIME")
	private String time;
	
	@TableField(value="METHOD")
	private String method;
	
	@TableField(value="PARAMS")
	private String params;
	
	@TableField(value="IP")
	private String ip;
	
	@TableField(value="CREATE_TIME")
	private Date createTime;
	
	@TableField(value="location")
	private String location;
}
