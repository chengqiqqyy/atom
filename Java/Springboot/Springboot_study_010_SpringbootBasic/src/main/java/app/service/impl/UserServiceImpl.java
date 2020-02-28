package app.service.impl;

import org.springframework.stereotype.Service;

import app.entity.user.User;
import app.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Override
	public User printUser(User user) {
		if(user == null) throw new RuntimeException("检查用户参数是否为空......");
		System.out.println(user.toString());
		return user;
	}
	
}
