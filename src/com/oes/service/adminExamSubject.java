package com.oes.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oes.mapper.ExamSubjectMapper;
import com.oes.pojo.ExamSubject;

@Service("adminExamSubject")
public class adminExamSubject {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Autowired
	private ExamSubjectMapper examSubjectMapper;
	
    public List<ExamSubject> subjectList(){
	 SqlSession session = sqlSessionFactory.openSession();
	 examSubjectMapper = session.getMapper(ExamSubjectMapper.class);
	 return examSubjectMapper.selectAll(); 
    }
  
    public int update(ExamSubject examSubject){
   	 SqlSession session = sqlSessionFactory.openSession();
   	 examSubjectMapper = session.getMapper(ExamSubjectMapper.class);
   	 return examSubjectMapper.updateByPrimaryKey(examSubject);
    }
    
    public int insert(ExamSubject examSubject){
      	 SqlSession session = sqlSessionFactory.openSession();
      	 examSubjectMapper = session.getMapper(ExamSubjectMapper.class);
      	 return examSubjectMapper.insert(examSubject);
    }
    
    public int delete(int examSubjectId){
      	 SqlSession session = sqlSessionFactory.openSession();
      	 examSubjectMapper = session.getMapper(ExamSubjectMapper.class);
      	 return examSubjectMapper.deleteByPrimaryKey(examSubjectId);
    }
}
