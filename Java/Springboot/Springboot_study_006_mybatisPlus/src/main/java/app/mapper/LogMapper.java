package app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import app.entity.Log;

public interface LogMapper extends BaseMapper<Log>{
	@Select("SELECT * FROM t_log")
	List<Log> selectLogs();
}
