package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;

@Controller
public class HomeController {
	
	//object UserRepo
	@Autowired
	UserRepo db;
	
	@RequestMapping("/")
	String MyFun(Model m)
	{
		User u=new User();//black object
		
		System.out.println("Data in u object befour form "+u);
		m.addAttribute("obj",u);
		
		return "Reg.html";
	}
	
	@RequestMapping("/regdata")
	ModelAndView MyFun1(@ModelAttribute("obj") User u1)
	{
			 
		System.out.println("Data in u object after form "+u1);
		
//		SaveUser(u1);
		db.save(u1);
		
		 ModelAndView mv=new ModelAndView("welcome.html");
		 mv.addObject("ob", u1);
		
		return mv;
	}
	
	
}
