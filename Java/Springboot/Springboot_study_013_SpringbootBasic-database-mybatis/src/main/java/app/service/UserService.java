package app.service;

import java.util.List;

import app.entity.User;

public interface UserService {
	public List<User> findAll();
	public User findUserById(Long id);
	public int insertUser(String username, int sex, String note);
	public int insertUserDefault(String username, int sex, String note);
	public int insertUserRequireNew(String username, int sex, String note);
	public int insertUserNested(String username, int sex, String note);
	public int insertUsersDefault(List<User> userList);
	public int insertUsersRequireNew(List<User> userList);
	public int insertUsersNested(List<User> userList);
}
