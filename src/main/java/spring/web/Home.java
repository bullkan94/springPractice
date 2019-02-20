
package spring.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mapper.Performance;

@Controller
public class Home {
	@Autowired
	PerformanceService performanceService;

	@RequestMapping(value="/", method=GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value="/{seq}", method=GET)
	public String selectSeq(@PathVariable String seq, Model m) {
		Performance p = performanceService.getPerformanceFromSeq(Integer.parseInt(seq));
		m.addAttribute(seq);
		return "test";
	}
	
	@RequestMapping(value="/test/{t}", method=GET)
	public String i(@PathVariable String t, Model m) {
		m.addAttribute(t);
		return "test";
	}
}

