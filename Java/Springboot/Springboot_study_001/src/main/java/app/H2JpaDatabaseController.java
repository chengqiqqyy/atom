package app;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import app.h2JpaDb.User;
import app.imp.UserRepository;


@Controller
public class H2JpaDatabaseController {
	@Autowired
	UserRepository repos;
	
	@GetMapping("/db")
	public ModelAndView index(@ModelAttribute("formModel") User user, ModelAndView mav) {
		mav.setViewName("db");
		Iterable<User> list = repos.findAll();
		mav.addObject("data",list);
		return mav;
	}
	
	@PostMapping("/db")
	@Transactional(readOnly=false)
	public ModelAndView form(@ModelAttribute("formModel") User user, ModelAndView mav) {
		repos.saveAndFlush(user);
		return new ModelAndView("redirect:/db");
	}
	
	@PostConstruct
	public void init() {
		//初始数据生成
		User user = new User();
		user.setName("Max");
		repos.saveAndFlush(user);
		
		user = new User();
		user.setName("Jack");
		repos.saveAndFlush(user);
		
	}
	
	
	
	
	
	
}
