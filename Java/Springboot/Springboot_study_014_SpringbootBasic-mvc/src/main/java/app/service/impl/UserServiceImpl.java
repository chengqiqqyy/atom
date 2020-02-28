package app.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.User;
import app.mapper.UserMapper;
import app.service.UserService;
import app.utils.MD5Utils;

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
		return userMapper.findUserById(id);
	}

	@Override
	public int insertUser(String username, String password) {
		try {
			return userMapper.insertUser(username, MD5Utils.encrypt(username, password));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int deleteUser(Long id) {
		return userMapper.deleteUser(id);
	}
	
	
	
}
