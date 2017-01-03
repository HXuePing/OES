package com.oes.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oes.pojo.ExamUser;
import com.oes.service.StuMaService;

@Controller
@RequestMapping("/stuma")
public class StuMaController {
	@Autowired
	private StuMaService stuMaService;
	//获取所有用户返回stu-ma.jsp
	@RequestMapping(value="/list")
	public ModelAndView stulist(){
		ModelAndView mav = new ModelAndView();
		List<ExamUser> list = stuMaService.selectAll();
		mav.setViewName("/stu-ma");
		mav.getModel().put("list", list);
		return mav;		
	}
	//删除一个用户
	@RequestMapping(value="/delete")
	public String deleteById(Integer examUserId){
		System.out.println("=======================进入删除");
		int i = stuMaService.deleteByExamUserId(examUserId);
		System.out.println("=======================删除操作影响了" + i + "行");
		return "redirect:/stuma/list";
		}
	
	//插入一个用户
	@RequestMapping(value="/insert")
	public String insert(ExamUser examUser) throws UnsupportedEncodingException{
		System.out.println("=======================进入插入");
		//中文乱码问题
		examUser.setExamUserSex(new String(examUser.getExamUserSex().getBytes("iso-8859-1"),"utf-8"));
		examUser.setExamUserName(new String(examUser.getExamUserName().getBytes("iso-8859-1"),"utf-8"));
		examUser.setExamUserAddress(new String(examUser.getExamUserAddress().getBytes("iso-8859-1"),"utf-8"));
		//插入前应该判断当前输入的 id 以及  学号 是否已经存在----等待实现
		int i = stuMaService.insertOne(examUser);
		System.out.println("=======================插入操作影响了" + i + "行");		
		return "redirect:/stuma/list";
		}
	//修改一个用户
	@RequestMapping(value="/update")
	public String updateById(ExamUser examUser) throws UnsupportedEncodingException{
		System.out.println("=======================进入修改");
		//中文乱码问题
		examUser.setExamUserSex(new String(examUser.getExamUserSex().getBytes("iso-8859-1"),"utf-8"));
		examUser.setExamUserName(new String(examUser.getExamUserName().getBytes("iso-8859-1"),"utf-8"));
		examUser.setExamUserAddress(new String(examUser.getExamUserAddress().getBytes("iso-8859-1"),"utf-8"));
		int i = stuMaService.updateByExamUserId(examUser);
		System.out.println("=======================插入操作影响了" + i + "行");		
		return "redirect:/stuma/list";
		}
	
}
