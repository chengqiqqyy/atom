package app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.User;
import app.mapper.UserMapper;
import app.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;
	
	@Override
	public List<User> findAllUser() {
		return userMapper.findAllUser();
	}
	@Override
	public User findUserById(long id) {
		return userMapper.findUserById(id);
	}
	@Override
	public User login(String username, String password) {
		return userMapper.login(username, password);
	}
}
