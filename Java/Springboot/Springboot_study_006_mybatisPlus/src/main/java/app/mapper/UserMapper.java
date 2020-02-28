package app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import app.entity.User;

public interface UserMapper extends BaseMapper<User> {
	@Select("SELECT * FROM user")
	  List<User> selectUsers();
}
