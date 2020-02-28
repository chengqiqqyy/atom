package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.User;
import app.jpa.repository.UserRepository;

@RestController
@RequestMapping("jpa")
public class JpaController {
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("all")
	public List<User> showAllUser(){
		List<User> userList = userRepository.findAll();
		System.out.println("JPA show all user.");
		userList.forEach(user -> System.out.println(user.getUsername()));
		return userList;
	}
	
}
