package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.User;
import app.service.UserService;
import app.service.UserValidator;

@RestController
public class AopController {
	@Autowired
	UserService userService;
	
	@RequestMapping("print")
	public User printUser(Long id, String username, String password) {
		User user = new User(id, username, password);
		/* Quetsion
		 * n直接@Autowired UserValidator 也能完成功能
		 * n不懂接口增强的实际应用
		 * 
		 */
		UserValidator userValidator = (UserValidator)userService;
		
		if(userValidator.validateUser(user)) {
			userService.printUser(user);
		}
		
		
		return user;
	}
	
	@GetMapping("manyaspects")
	public String manyAspects() {
		userService.manyAspects();
		return "Test many aspects.";
	}
}
