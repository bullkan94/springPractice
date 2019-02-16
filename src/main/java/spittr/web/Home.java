package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {

	@RequestMapping(value="/", method=GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value="/homee", method=GET)
	public String index() {
		return "home";
	}
}
