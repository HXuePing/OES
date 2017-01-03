package com.oes.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oes.mapper.ExamGradeMapper;
import com.oes.mapper.ExamSubjectMapper;
import com.oes.mapper.ExamTiMapper;
import com.oes.mapper.ExamUserMapper;
import com.oes.pojo.ExamGrade;
import com.oes.pojo.ExamInfo;
import com.oes.pojo.ExamSubject;
import com.oes.pojo.ExamTi;
import com.oes.pojo.ExamUser;

@Service
public class StudentService {
	
	@Resource
	private ExamSubjectMapper smapper;
	
	@Resource
	private ExamGradeMapper tmapper;
	
	@Resource
	private ExamTiMapper timapper;
	
	@Resource
	private ExamGradeMapper egmapper;
	
	@Resource
	private ExamUserMapper esmapper;
	
	public List<ExamSubject> selectAllSubject(){
		List<ExamSubject> list=smapper.selectAll();	
		return list;		
	}
	
	public List<ExamSubject> selectbySubject(Integer examSubjectId){
		List<ExamSubject> list=smapper.selectByPrimary(examSubjectId);	
		return list;		
	}

	public List<ExamSubject> selectBysubjectDone(ExamInfo examInfo) {
		List<ExamSubject> list=smapper.selectBysubjectDone(examInfo);
		return list;
	}
	

	public ExamGrade selectByGrade(Integer examSubjectId) {
		ExamGrade eg=tmapper.selectByPrimarysub(examSubjectId);
		return eg;
	}

	public List<ExamTi> selectbyti(Integer examSubjectId){
		List<ExamTi> list=timapper.selectByPrimarysub(examSubjectId);
		return list;		
	}
	

	public void insertExamGrade(ExamGrade examGrade){
		egmapper.insert(examGrade);
	}
	

	public void updatedone(ExamSubject examSubject){
		smapper.updateBydone(examSubject);
	}
	

	public ExamSubject getalltime(Integer examSubjectId){
		return smapper.selectsubtime(examSubjectId);
	}
	

	public ExamUser getStudent(Integer examUserId){
		return esmapper.selectByPrimaryKey(examUserId);
		
	}
}
