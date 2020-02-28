package app.controller;



import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import app.entity.RespBody;
import app.entity.User;
import app.mapper.UserMapper;
import app.utils.MD5Utils;

@Controller
public class ShiroController {
	@Autowired
	UserMapper userMapper;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	@ResponseBody
	public RespBody login(String username, String password, boolean rememberMe) {
		// MD5
		password = MD5Utils.encrypt(username, password);
		System.out.println("Password: " + password);
		UsernamePasswordToken token = new UsernamePasswordToken(username,password,rememberMe);
		System.out.println("Token: " + token.toString());
		// Get Subject object
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			System.out.println("login authentication done");
			return RespBody.ok();
		}catch(UnknownAccountException e) {
			return RespBody.error(e.getMessage());
		}catch(IncorrectCredentialsException e) {
			return RespBody.error(e.getMessage());
		}catch(LockedAccountException e) {
			return RespBody.error(e.getMessage());
		}catch(AuthenticationException e) {
			return RespBody.error("Authentication Failed.");
		}
	}
	
	@RequestMapping("/")
	public String redirectIndex() {
		return "redirect:index";
	}
	
	@RequestMapping("/index")
	public String index(Model model) {
		// After login success, you can get user info by Subject
		System.out.println("Principal: " + SecurityUtils.getSubject().getPrincipal());
		Session x = SecurityUtils.getSubject().getSession();
		x.getAttributeKeys().forEach(xx -> System.out.println(xx.toString()));
		System.out.println(x.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_AUTHENTICATED_SESSION_KEY"));
		System.out.println(x.getAttribute("org.apache.shiro.web.session.HttpServletSession.HOST_SESSION_KEY"));
		System.out.println(x.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY"));
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		model.addAttribute("user", user);
		return "index";
	}
	
	@GetMapping("/userList")
	public ModelAndView userList() {
		ModelAndView mav = new ModelAndView();
		List<User> userList = userMapper.findAllUser();
		mav.addObject(userList);
		mav.setViewName("userList");
		return mav;
	}
	
	
	
}
