package com.oes.mapper;

import java.util.List;

import com.oes.pojo.ExamGrade;
import com.oes.pojo.ExamInfo;
import com.oes.pojo.ExamSubject;

public interface ExamSubjectMapper {
	
	List<ExamSubject> selectByPrimary(Integer examUserId);
	public ExamSubject selectsubtime(Integer examSubjectId);
	public void updateBydone(ExamSubject examSubject);
	
	public List<ExamSubject> selectBysubjectDone(ExamInfo examInfo);
	
	public List<ExamSubject> selectAll();
	
	
	
    int deleteByPrimaryKey(Integer examSubjectId);

    int insert(ExamSubject record);
    ExamSubject findSubjectName(Integer examSubjectId);
    int insertSelective(ExamSubject record);
    List<ExamGrade> findAllSubject();
    ExamSubject selectByPrimaryKey(Integer examSubjectId);

    int updateByPrimaryKeySelective(ExamSubject record);

    int updateByPrimaryKey(ExamSubject record);
}