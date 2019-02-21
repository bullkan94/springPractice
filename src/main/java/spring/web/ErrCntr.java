package spring.web;

import org.springframework.stereotype.Controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrCntr implements ErrorController{

	@RequestMapping(value="/error", method=GET, produces="text/plan;charset=UTF-8")
	public String errorPage() {		
		return "404-page";
	}
	
	@Override
	public String getErrorPath() {
		return "/error";
	}
}
