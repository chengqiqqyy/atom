package app.service;

import org.springframework.beans.factory.annotation.Autowired;

public class TestService {
	@Autowired
	static UserService userService;
	
	public static void main(String[] args) {
		System.out.println(args[0]);
//		System.out.println(userService.getClass());
	}
}
