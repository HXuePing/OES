package com.oes.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.oes.pojo.ExamGrade;
import com.oes.pojo.ExamSubject;
import com.oes.pojo.ExamUser;
import com.oes.service.ExamGradeService;
import com.oes.service.ExamUserService;
import com.oes.service.ExamSubjectService;

@Controller
@RequestMapping(value="/teama")
public class TeaMaController {
	@Autowired
	private ExamUserService examUserService;
	
	@Autowired
	private ExamGradeService examGradeService;
	@Autowired
	private ExamSubjectService examSubjectService;
	
	@RequestMapping("/choose")
	public String PostChoose(Model model){
		System.out.println("进入PostChoose");
		List<ExamGrade> gradeList = examGradeService.SelectAllGrade();
		List<ExamGrade> subjectList = examSubjectService.SelectAllSubject();
		model.addAttribute("gradeList", gradeList);
		model.addAttribute("subjectList", subjectList);
		return "/TeaSeleteGrade";
	}
	@RequestMapping("/member")
	public String PostMember(Model model,Integer examSubjectId){
		System.out.println("进入Member");
		System.out.println(examSubjectId);
		ExamSubject Name =examSubjectService.findSubjectName(examSubjectId);		
		List<ExamGrade> stuList =examGradeService.SelectAllStuGrade(examSubjectId);
		List<ExamUser> examUser=new ArrayList<ExamUser>();
		for(ExamGrade grade:stuList){			
			examUser.add(examUserService.find(grade.getExamUserId()));
		}		
		model.addAttribute("examUser", examUser);
		model.addAttribute("stuList", stuList);
		model.addAttribute("Name", Name);
		
		return "/Stamp";
	}
	@RequestMapping("/selete")
	public String SeleteMember(Model model,Integer examSubjectId,Integer examUserId,String examUserName,String examGradeTime){
		System.out.println("进入Selete");
		System.out.println(examSubjectId);
		System.out.println(examUserId);
		System.out.println(examUserName);
		System.out.println(examGradeTime);
		/*examGradeTime = "2016-08-23";*/		
		ExamSubject Name =examSubjectService.findSubjectName(examSubjectId);
		model.addAttribute("Name", Name);
		if(examUserId==null&&examUserName.length()==0){
			System.out.println("11111");
			List<ExamGrade> stuList =examGradeService.SelectAllStuGrade(examSubjectId);
			List<ExamGrade> Grade=new ArrayList<ExamGrade>();
			List<ExamUser> examUser=new ArrayList<ExamUser>();
			for(ExamGrade grade:stuList){							
				/*ExamUser.add(ExamUserService.find(grade.getExamUserId()));*/
				Grade.add(examGradeService.findDate(examGradeTime));
			}
			model.addAttribute("Grade", Grade);
			System.out.println(Grade);
			/*model.addAttribute("ExamUser", ExamUser);*/
			
			return "/Stamp2";
		}
		else if(examUserName.length()==0){
				System.out.println("22222");
				int check = 0;
				ExamUser examUser = examUserService.find(examUserId);
				model.addAttribute("examUser", examUser);
				List<ExamGrade> stuList =examGradeService.SelectAllStuGrade(examSubjectId);
				for(ExamGrade examGrade:stuList){
					if(examUserId==examGrade.getExamUserId()){
						 check=0;
						break;
					}
					else {
						 check =2;
					}
				}
				if(check==2){
					model.addAttribute("check", check);
					List<ExamGrade> gradeList = examGradeService.SelectAllGrade();
					List<ExamGrade> subjectList = examSubjectService.SelectAllSubject();
					model.addAttribute("gradeList", gradeList);
					model.addAttribute("subjectList", subjectList);
					return "/TeaSeleteGrade";
				}
				for(ExamGrade grade:stuList){			

					grade.getExamGradeId(examGradeService.selectStuId(examUserId));
					model.addAttribute("grade", grade);
				}	
		}
		else if(examUserId==null){
				System.out.println("3333");
				int check = 0;
				ExamUser examUser = 	examUserService.findId(examUserName);
				model.addAttribute("examUser", examUser);
				List<ExamGrade> stuList =examGradeService.SelectAllStuGrade(examSubjectId);
				List<ExamUser> List =examUserService.findAllStu();
				for(ExamUser Stu:List){
					
					if(examUserName.equals(Stu.getExamUserName())){
						 check=0;
						break;
					}
					else {
						 check =3;
					}
				}
				if(check==3){
					model.addAttribute("check", check);
					List<ExamGrade> gradeList = examGradeService.SelectAllGrade();
					List<ExamGrade> subjectList = examSubjectService.SelectAllSubject();
					model.addAttribute("gradeList", gradeList);
					model.addAttribute("subjectList", subjectList);
					return "/TeaSeleteGrade";
				}
				for(ExamGrade grade:stuList){			
					grade.getExamGradeId(examUserService.findId(examUserName));
					model.addAttribute("grade", grade);
				}
				
		}
		else{
			System.out.println("22222");
			ExamUser examUser = 	examUserService.find(examUserId);
			model.addAttribute("examUser", examUser);
			if(examUserName.equals(examUser.getExamUserName())){
				int check=0;
				model.addAttribute("check", check);
			model.addAttribute("examUser", examUser);
			List<ExamGrade> stuList =examGradeService.SelectAllStuGrade(examSubjectId);
			for(ExamGrade grade:stuList){			
				grade.getExamGradeId(examGradeService.selectStuId(examUserId));
				model.addAttribute("grade", grade);
			}
			}	
			else {
				int check=1;
				model.addAttribute("check", check);
				List<ExamGrade> gradeList = examGradeService.SelectAllGrade();
				List<ExamGrade> subjectList = examSubjectService.SelectAllSubject();
				model.addAttribute("gradeList", gradeList);
				model.addAttribute("subjectList", subjectList);
				return "/TeaSeleteGrade";
				
			}
		}
		return "/Stamp1";
	}
	
	
}
	