package app.service;

import java.util.List;

import app.entity.User;

public interface UserService {
	List<User> findAll();
	User findUserById(Long id);
	User findUserByUsernameAndPassword(String username, String password);
	List<User> findUserLikeUsername(String username);
	int insertUser(User user);
	int updateUser(User user);
	int deleteUserById(Long id);
}
