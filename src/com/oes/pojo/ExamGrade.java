package com.oes.pojo;

import java.util.Date;

import org.springframework.stereotype.Repository;
@Repository
public class ExamGrade {
    private Integer examGradeId;

    private Integer examUserId;

    private Integer examSubjectId;

    private Integer examGradePoint;

    private Integer examGradeRight;

    private Integer examGradeSum;

    private Date examGradeTime;

    private Integer examGradeFlag;
    
public ExamGrade(){}
	
	public ExamGrade(Integer examGradeId, Integer examUserId, Integer examSubjectId, Integer examGradePoint,Integer examGradeRight,Integer examGradeSum,Date examGradeTime,Integer examGradeFlag) {
		this.examGradeId = examGradeId;
		this.examUserId = examUserId;
		this.examSubjectId = examSubjectId;
		this.examGradePoint = examGradePoint;
		this.examGradeRight = examGradeRight;
		this.examGradeSum = examGradeSum;
		this.examGradeTime = examGradeTime;
		this.examGradeFlag = examGradeFlag;
	}
    public Integer getExamGradeId() {
        return examGradeId;
    }
    
    public void setExamGradeId(Integer examGradeId) {
        this.examGradeId = examGradeId;
    }

    public Integer getExamUserId() {
        return examUserId;
    }

    public void setExamUserId(Integer examUserId) {
        this.examUserId = examUserId;
    }

    public Integer getExamSubjectId() {
        return examSubjectId;
    }

    public void setExamSubjectId(Integer examSubjectId) {
        this.examSubjectId = examSubjectId;
    }

    public Integer getExamGradePoint() {
        return examGradePoint;
    }

    public void setExamGradePoint(Integer examGradePoint) {
        this.examGradePoint = examGradePoint;
    }

    public Integer getExamGradeRight() {
        return examGradeRight;
    }

    public void setExamGradeRight(Integer examGradeRight) {
        this.examGradeRight = examGradeRight;
    }

    public Integer getExamGradeSum() {
        return examGradeSum;
    }

    public void setExamGradeSum(Integer examGradeSum) {
        this.examGradeSum = examGradeSum;
    }

    public Date getExamGradeTime() {
        return examGradeTime;
    }

    public void setExamGradeTime(Date examGradeTime) {
        this.examGradeTime = examGradeTime;
    }

    public Integer getExamGradeFlag() {
        return examGradeFlag;
    }

    public void setExamGradeFlag(Integer examGradeFlag) {
        this.examGradeFlag = examGradeFlag;
    }

	public void getExamGradeId(ExamGrade selectStuId) {
		// TODO Auto-generated method stub
		
	}

	public void getExamGradeId(ExamUser findId) {
		// TODO Auto-generated method stub
		
	}
}