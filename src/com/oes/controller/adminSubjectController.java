package com.oes.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import com.oes.pojo.ExamSubject;
import com.oes.service.adminExamSubject;

@Controller
@RequestMapping(value="/teacher")
public class adminSubjectController {
	   @Autowired
	   adminExamSubject adminExamSubject;
	   @Autowired
	   ExamSubject examSubject;
	   
	   @RequestMapping(value="/adminSubject",method = RequestMethod.GET)
	   public String listGrid(){
	
		   return "adminSubject";
	   }
	   @RequestMapping(value="/adminSubject",method = RequestMethod.POST)
	   public void subjectList(Model model,HttpServletRequest request,HttpServletResponse response,
		   		@RequestParam("page") int page,@RequestParam("rows") int rows,
		   		@RequestParam("sidx") String sidx,@RequestParam("sord") String sord){
		   
		   try{
			     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:MM:ss");
			   	List<ExamSubject> sysUserCnList = adminExamSubject.subjectList();    
			   	JsonArray array = new JsonArray();
			   	for(ExamSubject stu:sysUserCnList){
			   		Gson gson = new Gson();
			   		stu.setExamSubjectTotaltimeString(sdf.format(stu.getExamSubjectTotaltime()));
			   		JsonObject obj = (JsonObject) gson.getAdapter(ExamSubject.class).toJsonTree(stu);
			   		array.add(obj);
			   	}
			   	JsonObject resultObj = new JsonObject();
			   	resultObj.add("rows", array);
		   	
		  		response.reset();
		   		response.setContentType("application/json");
		  		response.setCharacterEncoding("utf-8");
		   		response.getWriter().println(resultObj.toString());
		   		
		  	}catch(IOException e){
		   		e.printStackTrace();
		  	}
		   }
	   
	   @RequestMapping(value="/edit",method =RequestMethod.POST)
		public void edit(ExamSubject examSubject,HttpServletResponse response) throws JSONException{
			JSONObject json = new JSONObject();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:MM:ss");
			try {
				examSubject.setExamSubjectTotaltime(sdf.parse(examSubject.getExamSubjectTotaltimeString()));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(adminExamSubject.update(examSubject)==1){
				
				json.put("edit", "success");
				
				try {
					response.reset();
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					response.getWriter().print(json.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				json.put("edit", "error");
			}
			
		}
		
		@RequestMapping(value="/add",method =RequestMethod.POST)
		public void add(ExamSubject examSubject,HttpServletResponse response) throws JSONException{
			JSONObject json = new JSONObject();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:MM:ss");
			try {
				examSubject.setExamSubjectTotaltime(sdf.parse(examSubject.getExamSubjectTotaltimeString()));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(adminExamSubject.insert(examSubject)==1){
				
				json.put("add", "success");
				
				try {
					response.reset();
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					response.getWriter().print(json.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				json.put("add", "error");
			}
		}
		
		@RequestMapping(value="/delete",method =RequestMethod.POST)
		public void delete(Model model,ExamSubject examSubject,HttpServletResponse response) throws JSONException{
		
			JSONObject json = new JSONObject();
			if(adminExamSubject.delete(examSubject.getExamSubjectId())==1){
				json.put("delete1", "success");
				try {
					response.reset();
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					response.getWriter().print(json.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				json.put("delete1", "error");
			}
		}
}
