package com.oes.mapper;

import java.util.List;

import com.oes.pojo.ExamTi;

public interface ExamTiMapper {
	
	List<ExamTi> selectByPrimarysub(Integer examSubjectId);
	
    int deleteByPrimaryKey(Integer examTiId);

    int insert(ExamTi record);

    int insertSelective(ExamTi record);

    ExamTi selectByPrimaryKey(Integer examTiId);

    int updateByPrimaryKeySelective(ExamTi record);

    int updateByPrimaryKey(ExamTi record);
}