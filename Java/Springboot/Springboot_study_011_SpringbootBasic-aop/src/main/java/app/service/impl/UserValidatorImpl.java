package app.service.impl;

import org.springframework.stereotype.Service;

import app.entity.User;
import app.service.UserValidator;

@Service
public class UserValidatorImpl implements UserValidator {

	@Override
	public boolean validateUser(User user) {
		System.out.println("引入新接口： " + this.getClass().getSimpleName());
		return user != null;
	}
	
}
