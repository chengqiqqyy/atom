package app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.User;
import app.mapper.UserMapper;
import app.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;

	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}
	
	@Override
	public User findUserById(Long id) {
		return userMapper.findById(id);
	}

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		return userMapper.findByUsernameAndPassword(username, password);
	}

	@Override
	public List<User> findUserLikeUsername(String username) {
		return userMapper.findLikeName(username);
	}
	
	@Override
	public int insertUser(User user) {
		return userMapper.insert(user);
	}

	@Override
	public int updateUser(User user) {
		return userMapper.update(user);
	}

	@Override
	public int deleteUserById(Long id) {
		return userMapper.deleteById(id);
	}
}
