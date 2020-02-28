package app.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import app.entity.Log;

@DS("slave_1")
public interface LogMapper extends BaseMapper<Log>{
	
}
