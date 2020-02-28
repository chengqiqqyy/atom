package app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerTestController {
	@RequestMapping("/model/{num}")
	public String index(@PathVariable int num, Model model) {
		int sum = (1+num)*num/2;
		model.addAttribute("type", "Model");
		model.addAttribute("msg", "Sum = " + sum);
		return "index";
	}
	
	@RequestMapping("modelandview/{num}")
	public ModelAndView index(@PathVariable int num, ModelAndView mav) {
		int sum = (1+num)*num/2;
		mav.addObject("type", "Model And View");
		mav.addObject("msg", "Sum = " + sum);
		mav.setViewName("index");
		return mav;
	}
	
//	@RequestMapping(value="/", method=RequestMethod.GET)
	@GetMapping("/")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg", "Enter your name please");
		return mav;
	}
	
//	@RequestMapping(value="/", method=RequestMethod.POST)
	@PostMapping("/")
	public ModelAndView send(@RequestParam("username") String str, ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg", "Enter your name please");
		mav.addObject("hiMsg", "Hello " + str + " !!");
		mav.addObject("value", str);
		return mav;
	}
	
	
}
