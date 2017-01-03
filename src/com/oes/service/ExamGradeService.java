package com.oes.service;




import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oes.mapper.ExamGradeMapper;
import com.oes.pojo.ExamGrade;




@Service
public class ExamGradeService implements IExamGradeService{
	@Autowired
	private ExamGradeMapper examGradeMapper;
	@Override
	public ExamGrade SelectGrade(Integer examGradeId){
		
		return examGradeMapper.selectByPrimaryKey(examGradeId);
	}
	public List<ExamGrade> SelectAllGrade(){
		
			List<ExamGrade> gradeList = examGradeMapper.findAllGrade();
			return gradeList;
		}
	public List<ExamGrade> SelectAllStuGrade(Integer examSubjectId){
			
			List<ExamGrade> stuList = examGradeMapper.findAllStuGrade(examSubjectId);
			return stuList;
		}
	public ExamGrade findDate(String examGradeTime){
		
		return examGradeMapper.findDate(examGradeTime);
	}
	
	public ExamGrade selectStuId(Integer examStuId){
		
		return examGradeMapper.selectOne(examStuId);
	}	
	
	@Override
	public void SeleteGrade(Integer examGradeId) {
		// TODO Auto-generated method stub
		
	}
}
