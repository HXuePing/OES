package com.oes.mapper;

import com.oes.pojo.ExamStudentSubject;
import com.oes.pojo.ExamStudentSubjectKey;

public interface ExamStudentSubjectMapper {
    int deleteByPrimaryKey(ExamStudentSubjectKey key);

    int insert(ExamStudentSubject record);

    int insertSelective(ExamStudentSubject record);

    ExamStudentSubject selectByPrimaryKey(ExamStudentSubjectKey key);

    int updateByPrimaryKeySelective(ExamStudentSubject record);

    int updateByPrimaryKey(ExamStudentSubject record);
}