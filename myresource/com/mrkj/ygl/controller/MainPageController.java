package com.mrkj.ygl.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mrkj.ygl.service.MainPageService;


@Controller
public class MainPageController {
	
	@Resource
	MainPageService mainPageService;
	
	//跳转到系统主页面（上方帖子列表+下方新建帖子）
	@RequestMapping(value="/goMainPage")
	public ModelAndView goMainPage(HttpServletRequest request,
			@RequestParam(name="page",defaultValue="1") Integer page,
			@RequestParam(name="row",defaultValue="40") Integer row) {
		
		ModelAndView mav =new ModelAndView("myJSP/mainPage");
		//获取所有帖子数据并返回view
		List<Map<String, Object>> mainContent= mainPageService.getMainPage((page-1)*row, row);
		mav.addObject("main", mainContent);
		//获取总帖子数
		Long count=mainPageService.getMainCount();
		//获取分页导航条的数据并返回view
		String pageHtml=mainPageService.getPage(count, page, row);
		mav.addObject("pageHtml", pageHtml);		
		
		return mav;
	}
	
	//处理帖子提交，并将数据返回视图
	@RequestMapping(value="/saveUEditorContent")
	public ModelAndView saveUEditorContent(HttpServletRequest request,String content,String mainTitle) {
		
		//新建要返回的ModelAndView对象
		ModelAndView mav = new ModelAndView();	
		
		
		String mainCreateuser=request.getRemoteAddr();
		int result=mainPageService.saveMainContent(content, mainTitle, mainCreateuser);
		if(result==1) {
			mav.setViewName("redirect:/goMainPage");
		}else {
			mav.setViewName("myJSP/error");
		}
		
		
		return mav;

	}
	
	

}
