package app;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import app.entity.Job;
import app.entity.Log;
import app.entity.User;
import app.mapper.JobMapper;
import app.mapper.LogMapper;
import app.mapper.UserMapper;

@Controller
public class MybatisTestController {
	@Resource
	UserMapper userMapper;
	@Resource
	JobMapper jobMapper;
	@Resource
	LogMapper logMapper;
	
	@GetMapping("/userList")
	public ModelAndView userList() {
		ModelAndView mav = new ModelAndView();
		List<User> userList = userMapper.selectUsers();
		mav.addObject(userList);
		mav.setViewName("userList");
		return mav;
	}
	
	@GetMapping("/jobList")
	public ModelAndView jobList() {
		ModelAndView mav = new ModelAndView();
		List<Job> jobList = jobMapper.selectJobs();
		mav.addObject(jobList);
		mav.setViewName("jobList");
		return mav;
	}
	
	@GetMapping("/logList")
	public ModelAndView logList() {
		ModelAndView mav = new ModelAndView();
		List<Log> logList = logMapper.selectLogs();
		mav.addObject(logList);
		mav.setViewName("logList");
		return mav;
	}
}
