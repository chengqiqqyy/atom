package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.User;
import app.enumeration.SexEnum;
import app.jdbctemplate.service.JdbcTemUserService;

/*
 * Jdbc Template 实际开发中使用相对较少，推介使用 JPA(Hibernate) or Mybatis
 */

@RestController
@RequestMapping("jdbc")
public class JdbcTemplateController {
	@Autowired
	JdbcTemUserService jdbcTemUserService;
	
	@RequestMapping("all")
	public List<User> showAllUser(){
		return jdbcTemUserService.showAllUser();
	}
	
	@RequestMapping("get")
	public User getUser(Long id) {
		User user = jdbcTemUserService.getUser(id);
		System.out.println(user.toString());
		return user;
	}
	
	@RequestMapping("insert")
	public User insertUser(String username, int sex, String note) {
		User user = new User();
		user.setUsername(username);
		user.setSex(SexEnum.getEnumById(sex));
		user.setNote(note);
		
		System.out.println(jdbcTemUserService.insertUser(user));
		
		return jdbcTemUserService.findUsers(username, note).get(0);
	}
	
	@RequestMapping("update")
	public User updateUser(Long id, String username, int sex, String note) {
		User user = new User();
		user.setId(id);
		user.setUsername(username);
		user.setSex(SexEnum.getEnumById(sex));
		user.setNote(note);
		
		System.out.println(jdbcTemUserService.updateUser(user));
		
		return jdbcTemUserService.getUser(id);
	}
	
	@RequestMapping("delete")
	public List<User> delete(Long id){
		System.out.println(jdbcTemUserService.deleteUser(id));
		return jdbcTemUserService.showAllUser();
	}
	
	
	
	
	
	
	
	
	
	
	
}
