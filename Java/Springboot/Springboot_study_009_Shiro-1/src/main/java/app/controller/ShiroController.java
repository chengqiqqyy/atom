package app.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import app.entity.RespBody;
import app.entity.User;
import app.mapper.UserMapper;

@Controller
public class ShiroController {
	@Resource
	UserMapper userMapper;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public RespBody login(@RequestParam String username, String password) {
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return RespBody.ok();
		} catch (UnknownAccountException e) {
			return RespBody.error(e.getMessage());
		}catch (IncorrectCredentialsException e) {
			return RespBody.error(e.getMessage());
		}catch (LockedAccountException e) {
			return RespBody.error(e.getMessage());
		}catch (UnauthenticatedException e) {
			return RespBody.error(e.getMessage());
		}
	}
	
	@RequestMapping("/")
	public String redirectIndex() {
		return "redirect:index";
	}
	
	@RequestMapping("/index")
	public String index(Model model) {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		model.addAttribute(user);
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
