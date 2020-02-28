package app.service;

import java.util.List;

import app.entity.User;

public interface UserService {
	List<User> findAll();
	User findUserById(Long id);
	int insertUser(String username, String password);
	int deleteUser(Long id);
}
