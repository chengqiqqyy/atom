package app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import app.entity.Job;

public interface JobMapper extends BaseMapper<Job> {
	@Select("SELECT * FROM t_job_log")
	List<Job> selectJobs();
}
