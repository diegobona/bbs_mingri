package com.mrkj.ygl.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;

import org.springframework.stereotype.Controller;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mrkj.ygl.util.PublicUtil;
import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;
import com.sun.org.apache.bcel.internal.generic.ReturnInstruction;

@Controller
public class MyFirstController {

	@RequestMapping(value="/myTest")
	public ModelAndView myTest() {
		ModelAndView mav=new ModelAndView("myJSP/test01");
		//返回的ModelAndView对象会跳转至对应的视图文件，这里是test01.jsp
		return mav;
	}
	
}
