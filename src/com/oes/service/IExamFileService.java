package com.oes.service;

import java.io.InputStream;
import java.util.List;

import com.oes.pojo.ExamUser;

public interface IExamFileService {
	public List<ExamUser> importExamUserByPoi(InputStream file);
}
