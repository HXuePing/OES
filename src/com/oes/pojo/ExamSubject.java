package com.oes.pojo;

import java.util.Date;

import org.springframework.stereotype.Repository;
@Repository
public class ExamSubject {
    private Integer examSubjectId;

    private String examSubjectName;

    private String examSubjectDescription;

    private Integer examSubjectTnumber;

    private Date examSubjectTotaltime;

    private Integer examSubjectSum;

    private Integer examSubjectFlag;

    private Integer examSubjectDone;
    private String examSubjectTotaltimeString;

    public Integer getExamSubjectId() {
        return examSubjectId;
    }

    public void setExamSubjectId(Integer examSubjectId) {
        this.examSubjectId = examSubjectId;
    }

    public String getExamSubjectName() {
        return examSubjectName;
    }

    public void setExamSubjectName(String examSubjectName) {
        this.examSubjectName = examSubjectName;
    }

    public String getExamSubjectDescription() {
        return examSubjectDescription;
    }

    public void setExamSubjectDescription(String examSubjectDescription) {
        this.examSubjectDescription = examSubjectDescription;
    }

    public Integer getExamSubjectTnumber() {
        return examSubjectTnumber;
    }

    public void setExamSubjectTnumber(Integer examSubjectTnumber) {
        this.examSubjectTnumber = examSubjectTnumber;
    }

    public Date getExamSubjectTotaltime() {
        return examSubjectTotaltime;
    }

    public void setExamSubjectTotaltime(Date examSubjectTotaltime) {
        this.examSubjectTotaltime = examSubjectTotaltime;
    }

    public Integer getExamSubjectSum() {
        return examSubjectSum;
    }

    public void setExamSubjectSum(Integer examSubjectSum) {
        this.examSubjectSum = examSubjectSum;
    }

    public Integer getExamSubjectFlag() {
        return examSubjectFlag;
    }

    public void setExamSubjectFlag(Integer examSubjectFlag) {
        this.examSubjectFlag = examSubjectFlag;
    }

    public Integer getExamSubjectDone() {
        return examSubjectDone;
    }

    public void setExamSubjectDone(Integer examSubjectDone) {
        this.examSubjectDone = examSubjectDone;
    }

	public String getExamSubjectTotaltimeString() {
		return examSubjectTotaltimeString;
	}

	public void setExamSubjectTotaltimeString(String examSubjectTotaltimeString) {
		this.examSubjectTotaltimeString = examSubjectTotaltimeString;
	}
}