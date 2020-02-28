package app.service.impl;

import org.springframework.stereotype.Service;

import app.entity.User;
import app.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public void printUser(User user) {
		System.out.println(user.toString());
	}

	@Override
	public void manyAspects() {
		System.out.println("【" + this.getClass().getSimpleName() + "】 ManyAspect test......");
	}
	
}
