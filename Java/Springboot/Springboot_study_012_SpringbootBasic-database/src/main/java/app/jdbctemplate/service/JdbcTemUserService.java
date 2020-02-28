package app.jdbctemplate.service;


import java.util.List;

import app.entity.User;

public interface JdbcTemUserService {
	public User getUser(Long id);
	public List<User> findUsers(String username, String note);
	public List<User> showAllUser();
	public int insertUser(User user);
	public int updateUser(User user);
	public int deleteUser(Long id);
}
