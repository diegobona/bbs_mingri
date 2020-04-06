package com.mrkj.ygl.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.springframework.stereotype.Controller;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mrkj.ygl.utils.StringUtils;

import sun.rmi.runtime.NewThreadAction;

@Controller
public class Test02Controller {
	
	
	//显示“新建帖子”页面
	@RequestMapping(value="/goTest02")
	public ModelAndView goTest02() {
		ModelAndView mav=new ModelAndView("myJSP/test02");
		return mav;
	}
	


}
