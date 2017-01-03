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
	//��ȡ�����û�����stu-ma.jsp
	@RequestMapping(value="/list")
	public ModelAndView stulist(){
		ModelAndView mav = new ModelAndView();
		List<ExamUser> list = stuMaService.selectAll();
		mav.setViewName("/stu-ma");
		mav.getModel().put("list", list);
		return mav;		
	}
	//ɾ��һ���û�
	@RequestMapping(value="/delete")
	public String deleteById(Integer examUserId){
		System.out.println("=======================����ɾ��");
		int i = stuMaService.deleteByExamUserId(examUserId);
		System.out.println("=======================ɾ������Ӱ����" + i + "��");
		return "redirect:/stuma/list";
		}
	
	//����һ���û�
	@RequestMapping(value="/insert")
	public String insert(ExamUser examUser) throws UnsupportedEncodingException{
		System.out.println("=======================�������");
		//������������
		examUser.setExamUserSex(new String(examUser.getExamUserSex().getBytes("iso-8859-1"),"utf-8"));
		examUser.setExamUserName(new String(examUser.getExamUserName().getBytes("iso-8859-1"),"utf-8"));
		examUser.setExamUserAddress(new String(examUser.getExamUserAddress().getBytes("iso-8859-1"),"utf-8"));
		//����ǰӦ���жϵ�ǰ����� id �Լ�  ѧ�� �Ƿ��Ѿ�����----�ȴ�ʵ��
		int i = stuMaService.insertOne(examUser);
		System.out.println("=======================�������Ӱ����" + i + "��");		
		return "redirect:/stuma/list";
		}
	//�޸�һ���û�
	@RequestMapping(value="/update")
	public String updateById(ExamUser examUser) throws UnsupportedEncodingException{
		System.out.println("=======================�����޸�");
		//������������
		examUser.setExamUserSex(new String(examUser.getExamUserSex().getBytes("iso-8859-1"),"utf-8"));
		examUser.setExamUserName(new String(examUser.getExamUserName().getBytes("iso-8859-1"),"utf-8"));
		examUser.setExamUserAddress(new String(examUser.getExamUserAddress().getBytes("iso-8859-1"),"utf-8"));
		int i = stuMaService.updateByExamUserId(examUser);
		System.out.println("=======================�������Ӱ����" + i + "��");		
		return "redirect:/stuma/list";
		}
	
}
