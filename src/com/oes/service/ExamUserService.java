package com.oes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oes.mapper.ExamUserMapper;
import com.oes.pojo.ExamUser;


@Service
public class ExamUserService implements IExamUserService {
	@Autowired
	private ExamUserMapper esm;
	
	@Override
	public ExamUser selectByexamUserNumber( String examUserNumber ) {
		ExamUser examUser = esm.selectByexamUserNumber(examUserNumber);
		return examUser;
	}
	
	@Override	
	public ExamUser find(Integer examStuId){
		
		return esm.selectByPrimaryKey(examStuId);
	}
	public ExamUser findId(String examStuName){
		return esm.findId(examStuName);
	}
	public List<ExamUser> findAllStu(){
		
		List<ExamUser> List = esm.findAllStu();
		return List;
	}
	
}
