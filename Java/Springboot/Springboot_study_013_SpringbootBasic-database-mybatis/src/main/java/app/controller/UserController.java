package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.User;
import app.enumeration.SexEnum;
import app.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping("all")
	public List<User> findAll(){
		List<User> userList = userService.findAll();
		userList.forEach(user -> System.out.println(user.toString()));
		return userList;
	}
	
	@RequestMapping("id")
	public User findUserById(Long id) {
		User user = userService.findUserById(id);
		System.out.println(user.toString());
		return user;
	}
	
	@RequestMapping("insert")
	public int insertUser(String username, String sex, String note) {
		int update = userService.insertUser(username,SexEnum.getSexEnumBySexName(sex.substring(0,1).toUpperCase()+sex.substring(1)).getId(),note);
		return update;
	}
	
	@RequestMapping("insertUsersDefault")
	public String insertUsersDefault() {
		List<User> userList = new ArrayList<User>();
		User user = new User();
		user.setUsername("Bob");
		user.setSex(SexEnum.getSexEnumById(2));
		user.setNote("Bob is a idiot.");
		userList.add(user);
		
		user = new User();
		user.setUsername("Katty");
		user.setSex(SexEnum.getSexEnumById(2));
		user.setNote("Katty is a cat.");
		userList.add(user);
		
		return "Reuqire : " + userService.insertUsersDefault(userList);
	}
	
	@RequestMapping("insertUsersRequireNew")
	public String insertUsersRequireNew() {
		List<User> userList = new ArrayList<User>();
		User user = new User();
		user.setUsername("Bob");
		user.setSex(SexEnum.getSexEnumById(2));
		user.setNote("Bob is a idiot.");
		userList.add(user);
		
		user = new User();
		user.setUsername("Katty");
		user.setSex(SexEnum.getSexEnumById(2));
		user.setNote("Katty is a cat.");
		userList.add(user);
		
		return "Requires_New : " + userService.insertUsersRequireNew(userList);
	}
	
	@RequestMapping("insertUsersNested")
	public String insertUsersNested() {
		List<User> userList = new ArrayList<User>();
		User user = new User();
		user.setUsername("Bob");
		user.setSex(SexEnum.getSexEnumById(2));
		user.setNote("Bob is a idiot.");
		userList.add(user);
		
		user = new User();
		user.setUsername("Katty");
		user.setSex(SexEnum.getSexEnumById(2));
		user.setNote("Katty is a cat.");
		userList.add(user);
		
		return "Nested: " + userService.insertUsersNested(userList);
	}
}
