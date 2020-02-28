package app.entity;

import java.sql.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("t_job_log")
public class Job {
	@TableId(value="log_id")
	private Long logId;
	
	@TableField(value="job_id")
	private Long jobId;
	
	@TableField(value="bean_name")
	private String beanName;
	
	@TableField(value="method_name")
	private String methodName;
	
	@TableField(value="params")
	private String params;
	
	@TableField(value="status")
	private String status;
	
	@TableField(value="error")
	private String error;
	
	@TableField(value="times")
	private String times;
	
	@TableField(value="create_time")
	private Date createTime;
}
