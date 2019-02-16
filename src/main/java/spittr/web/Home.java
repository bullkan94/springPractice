package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Home {

	//@ResponseBody
	@RequestMapping(value="/", method=GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value="/homee", method=GET)
	public String index() {
		return "home";
	}
}
