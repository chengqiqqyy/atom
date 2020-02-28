package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import app.entity.User;
import app.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("index")
	public String index() {
		return "index";
	}
	
	@GetMapping("signIn")
	public String signIn() {
		return "signIn";
	}
	
	@GetMapping("all")
	public ModelAndView findAllUser() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userList", userService.findAll());
		mav.setViewName("allUsers");
		return mav;
	}
	
	@GetMapping("{id}")
	public ModelAndView findUserById(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView();
		User user = userService.findUserById(id);
		if(user == null) {
			mav.setViewName("redirect:user/userInfo?error");
		}
		mav.addObject("user", user);
		mav.setViewName("userInfo");
		return mav;
	}
	
	@PostMapping("insert")
	public ModelAndView insertUser(String username, String password) {
		ModelAndView mav = new ModelAndView();
		System.out.println("insertControl: " + username + " " + password);
		int ret = userService.insertUser(username, password);
		System.out.println(ret);
		mav.setViewName("redirect:all");
		return mav;
	}
	
	@DeleteMapping("delete")
	public ModelAndView deleteUser(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:all");
		if(userService.deleteUser(id) < 0) {
			mav.setViewName("redirect:error/400");
		}
		return mav;
	}
	
	
}
