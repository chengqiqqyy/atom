package app;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import app.imp.UserRepository;
import app.db.User;

@Controller
public class H2JpaDatabaseController {
	@Autowired
	UserRepository repos;
	
	@GetMapping("/")
	public ModelAndView index(@ModelAttribute("formModel") User user, ModelAndView mav) {
		mav.setViewName("index");
		Iterable<User> list = repos.findAll();
		mav.addObject("data", list);
		return mav;
	}
	
	@GetMapping("/add")
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView();
		User data = new User();
		mav.addObject("formModel", data);
		mav.setViewName("newuser");
		return mav;
	}
	
	@GetMapping("/edit")
	@Transactional(readOnly=false)
	public ModelAndView edit(@RequestParam long id) {
		ModelAndView mav = new ModelAndView();
		User data = repos.findById(id).get();
		System.out.println(repos.findById(id).toString());
		mav.addObject("formModel", data);
		mav.setViewName("newuser");
		return mav;
	}
	
	@PostMapping("/save")
	@Transactional(readOnly=false)
	public ModelAndView save(@ModelAttribute("formModel") User user) {
		repos.saveAndFlush(user);
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("delete")
	@Transactional(readOnly=false)
	public ModelAndView delete(@RequestParam long id) {
		repos.deleteById(id);
		return new ModelAndView("redirect:/");
	}
	
	@PostConstruct
	public void init() {
		User user1 = new User();
		user1.setName("Tom");
		user1.setSex("Man");
		user1.setWork("Programer");
		user1.setHobby("Game");
		repos.saveAndFlush(user1);
		
		user1 = new User();
		user1.setName("Jack");
		user1.setSex("Man");
		user1.setWork("Programer");
		user1.setHobby("Anime");
		repos.saveAndFlush(user1);
	}
	
}
