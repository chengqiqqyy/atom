package app;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import app.entity.User;
import app.service.DepartmentService;
import app.service.UserService;

@Controller
public class MybatisController {
	@Resource
	UserService userService;
	@Resource
	DepartmentService departmentService;

	@GetMapping("/")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/login")
	public ModelAndView doLogin(@RequestParam String username, String password) {
		ModelAndView mav = new ModelAndView();
		User user = userService.login(username,password);
		if(user != null) {
			mav.addObject(user);
			mav.setViewName("index");
			return mav;
		}
		mav.setViewName("redirect:/?error");
		return mav;
	}
	
	@GetMapping("/userList")
	public ModelAndView userList() {
		ModelAndView mav = new ModelAndView();
		mav.addObject(userService.findAllUser());
		mav.setViewName("userList");
		return mav;
	}
	
	@GetMapping("/departmentList")
	public ModelAndView departmentList() {
		ModelAndView mav = new ModelAndView();
		mav.addObject(departmentService.findAllDepartment());
		mav.setViewName("departmentList");
		return mav;
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "login";
	}
	
}
