package com.oes.mapper;

import java.util.List;

import com.oes.pojo.ExamUser;

public interface ExamUserMapper {
	
	
 	List<ExamUser> findAllStu();
 	ExamUser findId(String examStuName);
	
	
	
    int deleteByPrimaryKey(Integer examUserId);

    int insert(ExamUser record);

    int insertSelective(ExamUser record);

    ExamUser selectByPrimaryKey(Integer examUserId);

		
	
    ExamUser selectByexamUserNumber(String examUserNumber);

    int updateByPrimaryKeySelective(ExamUser record);

    int updateByPrimaryKey(ExamUser record);
    
    List<ExamUser> selectAll();
    
    int deleteByExamUserId( Integer examUserId );
    
    int insertOne( ExamUser examUser );
    
    int updateByExamUserId( ExamUser examUser );
}