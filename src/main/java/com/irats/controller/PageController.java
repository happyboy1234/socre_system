package com.irats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转Controller
 * @author HP
 *
 */
@Controller
public class PageController {

	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	@RequestMapping("/score/{page}")
	public String showScorePage(@PathVariable String page) {
		return "/score/" + page;
	}
	@RequestMapping("/score/editpage/{page}")
	public String showEditpagePage(@PathVariable String page) {
		return "/score/editpage/" + page;
	}
	@RequestMapping("/outerPage/{page}")
	public String showOuterPage(@PathVariable String page) {
		return "/outerPage/" + page;
	}
	@RequestMapping("/bund/{page}")
	public String showBundPage(@PathVariable String page) {
		return "/bund/" + page;
	}
	@RequestMapping("/outerPage/editpage/{page}")
	public String showOuterEditpagePage(@PathVariable String page) {
		return "/outerPage/editpage/" + page;
	}
}
