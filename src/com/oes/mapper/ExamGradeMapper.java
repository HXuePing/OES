package com.oes.mapper;

import java.util.List;


import com.oes.pojo.ExamGrade;

public interface ExamGradeMapper {
	
	
	 ExamGrade selectByPrimarysub(Integer examGradeId);
	
    int deleteByPrimaryKey(Integer examGradeId);

    int insert(ExamGrade record);

    int insertSelective(ExamGrade record);

    ExamGrade selectByPrimaryKey(Integer examGradeId);
    List<ExamGrade> findAllGrade();
    List<ExamGrade> findAllStuGrade(Integer examSubjectId);
    int updateByPrimaryKeySelective(ExamGrade record);
    ExamGrade findDate(String examGradeTime);
    int updateByPrimaryKey(ExamGrade record);
    ExamGrade selectOne(Integer examUserId);


}