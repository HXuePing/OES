package com.oes.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oes.pojo.ExamUser;
import com.oes.service.ExamUserService;



@Controller
@RequestMapping(value="/login")
public class LoginController {
	@Autowired
	private ExamUserService eus;
	
	//登陆
	@RequestMapping(value="/login")
	public ModelAndView gotologin(){
		ModelAndView mav = new ModelAndView("/login");
		return mav;
		
	}
	//登出
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
			session.setAttribute("examUser", null);
			return "redirect:/login/login";			
		}
	
	//个人信息
		@RequestMapping(value="/info")
		public ModelAndView info(){
			ModelAndView mav = new ModelAndView("/info");
			return mav;			
		}
	
	//主页
	@RequestMapping(value="/index")
	public String loginByNumber(RedirectAttributes ra,HttpSession session, String examUserNumber,String examUserPassword) throws NullPointerException, ServletException, IOException{
		System.out.println("进来selectByexamUserNumber");		
		ExamUser examUser = eus.selectByexamUserNumber(examUserNumber);
		System.out.println("查询完毕:" + examUser  + "\n" + "session的值：" +  session.getAttribute("examUser"));
		/* 以下两个判断防止直接进入/login/index */
		//判断session是否存在，存在直接进入/login/index||if(examUserNumber==null)是防止登陆时直接跳转
		if(examUserNumber==null){
			if(session.getAttribute("examUser") != null){
				return "/index";
			}
			else{
				return "redirect:/login/login";
			}
		}	
		/*//空的学号直接返回/login/login。相当于直接访问/login/index
		if(examUserNumber==null){
			return "redirect:/login/login";
		}		*/
		try{		
		//判断学好和密码输入是否正确		
		if((examUserNumber.equals(examUser.getExamUserNumber().toString().trim()))&&(examUserPassword.equals(examUser.getExamUserPassword().toString().trim()))){
			
			System.out.println("登陆成功，跳转index页面");
			
			session.setAttribute("examUser", examUser);
			
			return "/index";
		}
		else{
			examUser = null;
			System.out.println("\n登陆失败！！！原因可能是密码错误");
			ra.addFlashAttribute("req", "密码错误！");
			System.out.println("返回到login.jsp" + "\n");
			return "redirect:/login/login";
		}
		}catch (NullPointerException npe){
			examUser = null;
			System.out.println(npe);
			System.out.println("\n登陆失败！！！原因可能是账号不存在");
//			req.setAttribute("req", "账号不存在");
//			req.getRequestDispatcher("login").forward(req, resp);
			ra.addFlashAttribute("req", "账号不存在！");
			
			System.out.println("E返回到login.jsp" + "\n");
			return "redirect:/login/login";
		}
		
	}	
}
