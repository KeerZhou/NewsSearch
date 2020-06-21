package com.sjy.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sjy.pojo.ResultModel;
import com.sjy.service.NewsService;

@Controller
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	@RequestMapping("/newsIndex")
	public String newsIndex(String queryString,Integer page,Model model) throws Exception{
		return "news_index";
	}
	
	@RequestMapping(value = "/newsList", method = RequestMethod.GET)
	public String newsList(@RequestParam("queryString") String queryString,Integer page,Model model) throws Exception{
		
		//查询新闻列表
		ResultModel result = newsService.query(queryString, page);
		//列表传递给jsp
		model.addAttribute("result", result);
		//参数回显
		model.addAttribute("queryString", queryString);
		model.addAttribute("page", page);
		
		return "news_list";
	}

	@RequestMapping(value ="/list", method = RequestMethod.GET)
	public String list(@RequestParam("queryString") String queryString,Integer page,Model model) throws Exception{
		
		//查询新闻列表
		ResultModel result = newsService.query(queryString, page);
		//列表传递给jsp
		model.addAttribute("result", result);
		//参数回显
		model.addAttribute("queryString", queryString);
		model.addAttribute("page", page);
		
		return "news_list";
	}
}
