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
	
	//��½
	@RequestMapping(value="/login")
	public ModelAndView gotologin(){
		ModelAndView mav = new ModelAndView("/login");
		return mav;
		
	}
	//�ǳ�
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
			session.setAttribute("examUser", null);
			return "redirect:/login/login";			
		}
	
	//������Ϣ
		@RequestMapping(value="/info")
		public ModelAndView info(){
			ModelAndView mav = new ModelAndView("/info");
			return mav;			
		}
	
	//��ҳ
	@RequestMapping(value="/index")
	public String loginByNumber(RedirectAttributes ra,HttpSession session, String examUserNumber,String examUserPassword) throws NullPointerException, ServletException, IOException{
		System.out.println("����selectByexamUserNumber");		
		ExamUser examUser = eus.selectByexamUserNumber(examUserNumber);
		System.out.println("��ѯ���:" + examUser  + "\n" + "session��ֵ��" +  session.getAttribute("examUser"));
		/* ���������жϷ�ֱֹ�ӽ���/login/index */
		//�ж�session�Ƿ���ڣ�����ֱ�ӽ���/login/index||if(examUserNumber==null)�Ƿ�ֹ��½ʱֱ����ת
		if(examUserNumber==null){
			if(session.getAttribute("examUser") != null){
				return "/index";
			}
			else{
				return "redirect:/login/login";
			}
		}	
		/*//�յ�ѧ��ֱ�ӷ���/login/login���൱��ֱ�ӷ���/login/index
		if(examUserNumber==null){
			return "redirect:/login/login";
		}		*/
		try{		
		//�ж�ѧ�ú����������Ƿ���ȷ		
		if((examUserNumber.equals(examUser.getExamUserNumber().toString().trim()))&&(examUserPassword.equals(examUser.getExamUserPassword().toString().trim()))){
			
			System.out.println("��½�ɹ�����תindexҳ��");
			
			session.setAttribute("examUser", examUser);
			
			return "/index";
		}
		else{
			examUser = null;
			System.out.println("\n��½ʧ�ܣ�����ԭ��������������");
			ra.addFlashAttribute("req", "�������");
			System.out.println("���ص�login.jsp" + "\n");
			return "redirect:/login/login";
		}
		}catch (NullPointerException npe){
			examUser = null;
			System.out.println(npe);
			System.out.println("\n��½ʧ�ܣ�����ԭ��������˺Ų�����");
//			req.setAttribute("req", "�˺Ų�����");
//			req.getRequestDispatcher("login").forward(req, resp);
			ra.addFlashAttribute("req", "�˺Ų����ڣ�");
			
			System.out.println("E���ص�login.jsp" + "\n");
			return "redirect:/login/login";
		}
		
	}	
}
