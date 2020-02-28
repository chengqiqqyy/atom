package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.user.User;
import app.service.UserService;

@RestController
public class TestAopController {
	@Autowired
	User user;
	@Autowired
	UserService userService;
	
	@RequestMapping("print")
	public User printUser(int flag) {
		if(flag == 1) {
			userService.printUser(null);
			return user;
		}
		
		user.setId(100l);
		user.setUsername("Jack");
		user.setAge(22);
		user.setNote("What the fuck");
		
		userService.printUser(user);
		System.out.println("Controller: " + user.toString());
		
		return user;
	}
}
