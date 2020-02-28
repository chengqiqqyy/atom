package app;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import app.db.User;
import app.imp.UserRepository;

@Controller
public class SpringbootStudy005ReviewController {
	@Autowired
	UserRepository repos;
	
	@GetMapping("/")
	public String login() {
		return "login";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@PostMapping("/login")
	public ModelAndView login(@RequestParam String username, String password) {
		ModelAndView mav = new ModelAndView();
		User user = new User();
		user = repos.findByUsername(username);
		if(user != null) {
			mav.addObject("user",user);
			mav.setViewName("index");
			return mav;
		}
		mav.setViewName("redirect:/?error");
		return mav;
	}
	
	@GetMapping("/show")
	public ModelAndView show() {
		ModelAndView mav = new ModelAndView();
		List<User> userList = new ArrayList<>();
		userList = repos.findAll();
		mav.addObject("userList", userList);
		mav.setViewName("/userlist");
		return mav;
	}
	
	
	@PostConstruct
	public void init() {
		User user = new User();
		user.setUsername("Admin");
		user.setPassword("admin");
		repos.saveAndFlush(user);
		
		user = new User();
		user.setUsername("Jack");
		user.setPassword("jack");
		repos.saveAndFlush(user);
		
		user = new User();
		user.setUsername("Tom");
		user.setPassword("tom");
		repos.saveAndFlush(user);
	}
}
