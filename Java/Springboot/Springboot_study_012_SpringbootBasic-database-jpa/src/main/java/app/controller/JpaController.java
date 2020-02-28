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
		userList.forEach(user -> System.out.println(user.toString()));
		return userList;
	}
	
	@RequestMapping("users")
	public List<User> findUsers(String username, String note){
		List<User> userList = userRepository.findUsers(username, note);
		userList.forEach(user -> System.out.println(user.toString()));
		return userList;
	}
	
	@RequestMapping("id")
	public User findUserById(Long id) {
		User user = userRepository.findUserById(id);
		System.out.println(user.toString());
		return user;
	}
	
	@RequestMapping("findUserByUsernameLike")
	public List<User> findUserByUsernameLike(String username){
		List<User> userList = userRepository.findUserByUsernameLike("%" + username + "%");
		userList.forEach(user -> System.out.println(user.toString()));
		return userList;
	}
	
	@RequestMapping("findUserByUsernameLikeOrNoteLike")
	public List<User> findUserByUsernameLikeOrNoteLike(String username, String note){
		List<User> userList = userRepository.findUserByUsernameLikeOrNoteLike("%" + username + "%", "%" + note + "%");
		userList.forEach(user -> System.out.println(user.toString()));
		return userList;
	}
	
}
