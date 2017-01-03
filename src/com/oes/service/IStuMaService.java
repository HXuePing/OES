package com.oes.service;

import java.util.List;

import com.oes.pojo.ExamUser;

public interface IStuMaService {
	public List<ExamUser> selectAll();
	public int deleteByExamUserId( Integer examUserId );
	public int insertOne( ExamUser examUser );
	public int updateByExamUserId( ExamUser examUser );
}
