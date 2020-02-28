package app;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import app.db.User;
import app.imp.UserRepository;

@Controller
public class LoginController {
	@Autowired
	UserRepository repos;
	
	@Autowired
	PasswordEncoder pde;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new Pbkdf2PasswordEncoder();
//		return new BCryptPasswordEncoder();
	}
	
	/*public ModelAndView index(@RequestParam("username") String username) {
		ModelAndView mav = new ModelAndView();
		User user = new User();
		user = repos.findByUsername(username);
		mav.addObject("user", user);
		mav.setViewName("index");
		return mav;*/
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	String login() {
		return "login";
	}
	
	@GetMapping("/show")
	public ModelAndView show() {
		ModelAndView mav = new ModelAndView();
		Iterable<User> list = repos.findAll();
		mav.addObject("userList",list);
		mav.setViewName("userlist");
		return mav;
	}
	
	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView();
		User user = new User();
		mav.addObject("data", user);
		mav.setViewName("register");
		return mav;
	}
	
	@PostMapping("/regist")
	public ModelAndView regist(@ModelAttribute("data") User user) {
		User userExist = repos.findByUsername(user.getUsername());
		if(userExist != null) {
			System.out.println("Username already exist.");
			return new ModelAndView("redirect:register?error");	
		}
		user.setPassword(pde.encode(user.getPassword()));
		repos.saveAndFlush(user);
		System.out.println(user.getUsername() + " " + user.getPassword());
		return new ModelAndView("redirect:login");
	}
	
	
	@PostConstruct
	public void init() {
		User user = new User();
		user.setUsername("Admin");
		user.setPassword(pde.encode("admin"));
		repos.saveAndFlush(user);
		
		user = new User();
		user.setUsername("Jack");
		user.setPassword(pde.encode("jack"));
		repos.saveAndFlush(user);
		
		user = new User();
		user.setUsername("Tom");
		user.setPassword(pde.encode("tom"));
		repos.saveAndFlush(user);
	}
	
}
