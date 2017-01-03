package com.oes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oes.mapper.ExamUserMapper;
import com.oes.pojo.ExamUser;
@Service
public class StuMaService implements IStuMaService {
	@Autowired
	private ExamUserMapper esm;
	@Override
	public List<ExamUser> selectAll() {
		List<ExamUser> examUsers = esm.selectAll();
		return examUsers;
	}

	@Override
	public int deleteByExamUserId(Integer examUserId) {
		int i = esm.deleteByExamUserId(examUserId);
		return i;
	}

	@Override
	public int insertOne(ExamUser examUser) {
		int i = esm.insertOne(examUser);
		return i;
	}

	@Override
	public int updateByExamUserId(ExamUser examUser) {
		int i = esm.updateByExamUserId(examUser);
		return i;
	}



}
