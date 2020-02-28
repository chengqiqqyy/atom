package app.mapper;

import java.util.List;

import app.entity.User;

public interface UserMapper {
	public List<User> findAllUser();
	public User findUserById(long id);
	public User login(String username, String password);
}
