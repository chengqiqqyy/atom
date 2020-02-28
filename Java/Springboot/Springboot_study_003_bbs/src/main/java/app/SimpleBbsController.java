package app;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import app.db.User;
import app.imp.UserRepository;

@Controller
public class SimpleBbsController {	
	@Autowired
	UserRepository repos;
	
	@GetMapping("/")
	public ModelAndView index(@ModelAttribute("formModel") User user, ModelAndView mav) {
		mav.setViewName("index");
		Iterable<User> list = repos.findAll();
		mav.addObject("data", list);
		return mav;
	}
	
	
	@GetMapping("/show")
	@Transactional(readOnly=false)
	public ModelAndView show(@RequestParam int id) {
		ModelAndView mav = new ModelAndView();
		User data = repos.findById(id);
		mav.addObject("data", data);
		mav.setViewName("show");
		return mav;
	}
	
	@GetMapping("/add")
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView();
		User user = new User();
		mav.addObject("data", user);
		mav.setViewName("new");
		return mav;
	}
	
	@GetMapping("/edit")
	@Transactional(readOnly=false)
	public ModelAndView edit(@RequestParam int id) {
		ModelAndView mav = new ModelAndView();
		User data = repos.findById(id);
		mav.addObject("data", data);
		mav.setViewName("new");
		return mav;
	}
	
	@PostMapping("/save")
	@Transactional(readOnly=false)
	public ModelAndView save(@ModelAttribute("data") User user) {
		user.setDate(new Date());
		repos.saveAndFlush(user);
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("/delete")
	@Transactional(readOnly=false)
	public ModelAndView delete(@RequestParam int id) {
		repos.deleteById(id);
		return new ModelAndView("redirect:/");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@PostConstruct
	public void init() {
		User user = new User();
		user.setDate(new Date());
		user.setUsername("Anna");
		user.setTitle("Happy Day");
		user.setContent("What a nice day today!!");
		repos.saveAndFlush(user);
		
		user = new User();
		user.setDate(new Date());
		user.setUsername("Bob");
		user.setTitle("OHHHHHHHHHHHHHHHHHHHHHHH");
		user.setContent("I have done a very cool thing today!!");
		repos.saveAndFlush(user);
		
		user = new User();
		user.setDate(new Date());
		user.setUsername("Carl");
		user.setTitle("Bad Day");
		user.setContent("Today is the worest day ever!!");
		repos.saveAndFlush(user);
	}
}
