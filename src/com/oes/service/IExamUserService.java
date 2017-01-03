package com.oes.service;

import java.util.List;

import com.oes.pojo.ExamUser;

public interface IExamUserService {
	public ExamUser selectByexamUserNumber( String examUserNumber );
	public ExamUser find(Integer examStuId);
	public ExamUser findId(String examStuName);
	public List<ExamUser> findAllStu();
}
