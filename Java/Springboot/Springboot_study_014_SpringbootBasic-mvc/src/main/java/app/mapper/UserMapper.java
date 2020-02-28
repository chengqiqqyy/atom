package app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import app.entity.User;

@Mapper
public interface UserMapper {
	List<User> findAll();
	User findUserById(Long id);
	int insertUser(String username, String password);
	int deleteUser(Long id);
}
