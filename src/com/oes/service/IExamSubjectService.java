package com.oes.service;

import java.util.List;

import com.oes.pojo.ExamGrade;
import com.oes.pojo.ExamSubject;

public interface IExamSubjectService {
	public void SeleteSubject(Integer examSubjectId);

	ExamSubject SelectSubject(Integer examSubjectId);
	public List<ExamGrade> SelectAllSubject();
	public ExamSubject findSubjectName(ExamSubject examSubjectName);
}
