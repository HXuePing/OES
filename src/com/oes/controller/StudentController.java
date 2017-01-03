package com.oes.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.oes.pojo.ExamGrade;
import com.oes.pojo.ExamInfo;
import com.oes.pojo.ExamSubject;
import com.oes.pojo.ExamTi;
import com.oes.pojo.ExamUser;
import com.oes.service.StudentService;



@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Resource
	private StudentService service;
	
	Gson gson=new Gson();
	
	
	@RequestMapping("/index")
	public String  index(){
		return "examination";		
	}
	
	@RequestMapping("/left")
	public String  indexleft(){
		return "left";		
	}
	
		
	@RequestMapping("/head")
	public String  indexhead(){
		return "head";		
	}
	
	@RequestMapping("/listPage")
	public String  indexpage(){
		return "subjectlist";		
	}
		
	//jqGrid鑾峰彇鏁版嵁
	@RequestMapping("/listSubject")
	public void findallsubject(HttpServletResponse response,HttpSession session) throws IOException{		
		//闇�login鐧诲綍浼犲叆涓�釜stuid
		
		ExamUser euser= (ExamUser) session.getAttribute("examUser");
		System.out.println("===euser"+euser);
		
		List<ExamSubject> list=service.selectbySubject(euser.getExamUserId());
		String json=gson.toJson(list);
		System.out.print("list"+list);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf8");
		PrintWriter w=response.getWriter();
		w.write(json);			
	}
			
	
	@RequestMapping(value="/listBydone")
	public String findbydone(Model model,HttpServletResponse response,ExamInfo info,HttpSession session) throws IOException {			
		//闇�login鐧诲綍浼犲叆涓�釜stuid
		ExamUser euser= (ExamUser) session.getAttribute("examUser");		
		info.setExamUserid(euser.getExamUserId());
		info.setExamdone(1);
		List<ExamSubject> list=service.selectBysubjectDone(info);
		model.addAttribute("list",list);	
		return "listBydone";
	}
	
	@RequestMapping(value="/listNodone")
	public String findnodone(Model model,HttpServletResponse response,ExamInfo info,HttpSession session) throws IOException {
		//闇�login鐧诲綍浼犲叆涓�釜stuid
		ExamUser euser= (ExamUser) session.getAttribute("examUser");
		
		info.setExamUserid(euser.getExamUserId());
		info.setExamdone(0);
		List<ExamSubject> list=service.selectBysubjectDone(info);
		model.addAttribute("list",list);	
		return "listBydone";
	}
	
	@RequestMapping(value="/listbygrade/{examSubjectId}",method=RequestMethod.GET)
	public String listbygrade(Model model,HttpServletResponse response,@PathVariable Integer examSubjectId,HttpSession session) throws IOException {			
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		
		//System.out.println(examSubjectId+"====grade");
		
		ExamGrade grade=service.selectByGrade(examSubjectId);
	
	//	System.out.println(grade+"====grade");
		
		Date d=grade.getExamGradeTime();
		String date =format.format(d);
	
		ExamUser euser= (ExamUser) session.getAttribute("examUser");
		ExamUser stu=service.getStudent(euser.getExamUserId());
	//	System.out.println(grade+"====stu");
		
		ExamSubject es=service.getalltime(examSubjectId);
	//	System.out.println(grade+"====es");
		
		model.addAttribute("stu", stu);
		model.addAttribute("grade",grade);
		model.addAttribute("es", es);
		model.addAttribute("date", date);
		return "listbygrade";
	}
	
	@RequestMapping(value="/test/{examSubjectId}",method=RequestMethod.GET)
	public String test(Model model,@PathVariable Integer examSubjectId) throws IOException {	
	
		List<ExamTi> list=service.selectbyti(examSubjectId);
		model.addAttribute("examTi",list);
		int length=list.size();
		model.addAttribute("length",length);
		
		TimerData time=new TimerData();
		time.settime(5);
		
		return "test";
	}
	
	@RequestMapping(value="/checkscore")
	public String checktest(Model model,HttpServletRequest request,HttpSession session) throws IOException {					
			ExamUser euser= (ExamUser) session.getAttribute("examUser");
		
		
			String scorekey=request.getParameter("sco");
			String rightcount=request.getParameter("rig");
			String leng=request.getParameter("leng");
			String examSubjectId=request.getParameter("examSubjectId");
		
			
			
			ExamGrade examGrade=new ExamGrade();
			
			examGrade.setExamUserId(euser.getExamUserId());
			examGrade.setExamGradeFlag(1);
			examGrade.setExamGradePoint(Integer.parseInt(scorekey));
			examGrade.setExamGradeRight(Integer.parseInt(rightcount));
			examGrade.setExamGradeSum(Integer.parseInt(rightcount));
			examGrade.setExamSubjectId(Integer.parseInt(examSubjectId));
			examGrade.setExamGradeTime(new Date());
			
			
			service.insertExamGrade(examGrade);
			
			
			ExamSubject es=new ExamSubject();
			es.setExamSubjectId(Integer.parseInt(examSubjectId));
			es.setExamSubjectDone(1);
			
			service.updatedone(es);
			
			model.addAttribute("examGrade",examGrade);
			
			return "success";			
	}
}
