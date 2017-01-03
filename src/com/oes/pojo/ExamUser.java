package com.oes.pojo;

import java.util.Date;

public class ExamUser {
    private Integer examUserId;

    private String examUserName;

    private String examUserNumber;

    private String examUserPassword;

    private String examUserTeacher;

    private String examUserSex;

    private Date examUserBirthday;

    private String examUserTel;

    private String examUserAddress;

    private Integer examUserDone;
    public ExamUser(){}
	
	public ExamUser(Integer examUserId, String examUserName, String examUserNumber, String examUserPassword,String examUserSex,Date examUserBirthday,String examUserTel,String examUserAddress,Integer examUserDone) {
		this.examUserId = examUserId;
		this.examUserName = examUserName;
		this.examUserNumber = examUserNumber;
		this.examUserPassword = examUserPassword;
		this.examUserSex = examUserSex;
		this.examUserBirthday = examUserBirthday;
		this.examUserTel = examUserTel;
		this.examUserAddress = examUserAddress;
		this.examUserDone = examUserDone;
	}
    public Integer getExamUserId() {
        return examUserId;
    }

    public void setExamUserId(Integer examUserId) {
        this.examUserId = examUserId;
    }

    public String getExamUserName() {
        return examUserName;
    }

    public void setExamUserName(String examUserName) {
        this.examUserName = examUserName;
    }

    public String getExamUserNumber() {
        return examUserNumber;
    }

    public void setExamUserNumber(String examUserNumber) {
        this.examUserNumber = examUserNumber;
    }

    public String getExamUserPassword() {
        return examUserPassword;
    }

    public void setExamUserPassword(String examUserPassword) {
        this.examUserPassword = examUserPassword;
    }

    public String getExamUserTeacher() {
        return examUserTeacher;
    }

    public void setExamUserTeacher(String examUserTeacher) {
        this.examUserTeacher = examUserTeacher;
    }

    public String getExamUserSex() {
        return examUserSex;
    }

    public void setExamUserSex(String examUserSex) {
        this.examUserSex = examUserSex;
    }

    public Date getExamUserBirthday() {
        return examUserBirthday;
    }

    public void setExamUserBirthday(Date examUserBirthday) {
        this.examUserBirthday = examUserBirthday;
    }

    public String getExamUserTel() {
        return examUserTel;
    }

    public void setExamUserTel(String examUserTel) {
        this.examUserTel = examUserTel;
    }

    public String getExamUserAddress() {
        return examUserAddress;
    }

    public void setExamUserAddress(String examUserAddress) {
        this.examUserAddress = examUserAddress;
    }

    public Integer getExamUserDone() {
        return examUserDone;
    }

    public void setExamUserDone(Integer examUserDone) {
        this.examUserDone = examUserDone;
    }

	@Override
	public String toString() {
		return "ExamUser [examUserId=" + examUserId + ", examUserName=" + examUserName + ", examUserNumber="
				+ examUserNumber + ", examUserPassword=" + examUserPassword + ", examUserTeacher=" + examUserTeacher
				+ ", examUserSex=" + examUserSex + ", examUserBirthday=" + examUserBirthday + ", examUserTel="
				+ examUserTel + ", examUserAddress=" + examUserAddress + ", examUserDone=" + examUserDone + "]";
	}
}