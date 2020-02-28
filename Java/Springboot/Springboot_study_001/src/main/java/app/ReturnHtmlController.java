package app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReturnHtmlController {
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
}
