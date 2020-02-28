package app.service;

import java.util.List;

import app.entity.User;

public interface UserService {
	List<User> findAllUser();
	User findUserById(long id);
	User login(String username, String password);
}
