package app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import app.entity.User;

@Mapper
public interface UserMapper {
	public List<User> findAllUser();
	public User findUserByUsername(String username);
}
