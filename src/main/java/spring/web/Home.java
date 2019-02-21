
package spring.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.mapper.News;

@Controller
public class Home {
	private SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	private SimpleDateFormat todayDateFormat = new SimpleDateFormat("yyyyMMdd000000");
	
	private String getNowDate() {
		return inputDateFormat.format(new Date());
	}
	
	private String getTodayDate() {
		return todayDateFormat.format(new Date());
	}
	
	@Autowired
	NewsService newsService;
	
	@RequestMapping(value="/", method=GET)
	public String root() {
		return "redirect:home";
	}

	@RequestMapping(value="/home", method=GET)
	public String selectSeq(Model m) {
		m.addAttribute("total", newsService.getNewsTotal());
		m.addAttribute("today", newsService.getNewsTodays(getTodayDate()));
		m.addAttribute("news", newsService.getNewsRecent());
		return "index";
	}
	
	@RequestMapping(value="/add", method=POST, produces="text/plan;charset=UTF-8")
	public String insertNews(@ModelAttribute("news") News news) {
		news.pubDate = getNowDate();
		newsService.insertNews(news); 
		
		return "redirect:/home";
	}
	
	@RequestMapping(value="/add", method=GET, produces="text/plan;charset=UTF-8")
	public String addP(Model m) {
		m.addAttribute("news", new News());
		return "addPage";
	}
	
	@RequestMapping(value="/update", method=GET, produces="text/plan;charset=UTF-8")
	public String updateP(@RequestParam("idx") int idx, Model m) {
		m.addAttribute("news", new News());
		m.addAttribute("info", newsService.getNewsFromIdx(idx));
		return "lookup";
	}
	
	@RequestMapping(value="/update", method=POST, produces="text/plan;charset=UTF-8")
	public String updateNews(@ModelAttribute("news") News news) {
		newsService.updateNews(news);
		return "redirect:/home";
	}
	
	@RequestMapping(value="/delete", method=GET, produces="text/plan;charset=UTF-8")
	public String deleteP(@RequestParam("idx") int idx) {
		newsService.deleteNewsFromIdx(idx);
		return "redirect:/home";
	}
}

