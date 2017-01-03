package com.oes.service;

import java.util.Date;
import java.util.List;

import com.oes.pojo.ExamGrade;

public interface IExamGradeService {

	public void SeleteGrade(Integer examGradeId);

	ExamGrade SelectGrade(Integer examGradeId);
	public List<ExamGrade> SelectAllGrade();
	public List<ExamGrade> SelectAllStuGrade(Integer examSubjectId);
	public ExamGrade findDate(String examGradeTime);
	public ExamGrade selectStuId(Integer examStuId);
}
