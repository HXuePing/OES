package com.oes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oes.mapper.ExamSubjectMapper;
import com.oes.pojo.ExamGrade;
import com.oes.pojo.ExamSubject;



@Service

public class ExamSubjectService implements IExamSubjectService{
	@Autowired
	private ExamSubjectMapper examSubjectMapper;
	@Override
	public ExamSubject SelectSubject(Integer examSubjectId){
		
		return examSubjectMapper.selectByPrimaryKey(examSubjectId);
	}
	public List<ExamGrade> SelectAllSubject(){
		
		List<ExamGrade> subjectList = examSubjectMapper.findAllSubject();
		return subjectList;
	}
	public ExamSubject findSubjectName(Integer examSubjectId){
		return examSubjectMapper.findSubjectName(examSubjectId);
	}
	@Override
	public void SeleteSubject(Integer examSubjectId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ExamSubject findSubjectName(ExamSubject examSubjectName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
