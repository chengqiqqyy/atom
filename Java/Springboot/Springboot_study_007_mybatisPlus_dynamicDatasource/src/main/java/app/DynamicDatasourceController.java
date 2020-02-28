package app;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import app.entity.Job;
import app.mapper.JobMapper;
import app.mapper.LogMapper;
import app.mapper.UserMapper;

@Controller
public class DynamicDatasourceController {
	@Resource
	UserMapper userMapper;
	@Resource
	JobMapper jobMapper;
	@Resource
	LogMapper logMapper;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("userList")
	public ModelAndView userList() {
		ModelAndView mav = new ModelAndView();
		mav.addObject(userMapper.selectList(null));
		mav.setViewName("userList");
		return mav;
	}
	
	@GetMapping("jobList")
	public ModelAndView jobList() {
		ModelAndView mav = new ModelAndView();
		List<Job> jobList = jobMapper.selectList(null);
		mav.addObject(jobList);
		mav.setViewName("jobList");
		return mav;
	}
	
	@GetMapping("logList")
	public ModelAndView logList() {
		ModelAndView mav = new ModelAndView();
		mav.addObject(logMapper.selectList(null));
		mav.setViewName("logList");
		return mav;
	}
}
