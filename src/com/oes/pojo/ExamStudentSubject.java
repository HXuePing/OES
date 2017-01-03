package com.oes.pojo;

import java.util.Date;

public class ExamStudentSubject extends ExamStudentSubjectKey {
    private String upduser;

    private Date upddate;

    public String getUpduser() {
        return upduser;
    }

    public void setUpduser(String upduser) {
        this.upduser = upduser;
    }

    public Date getUpddate() {
        return upddate;
    }

    public void setUpddate(Date upddate) {
        this.upddate = upddate;
    }
}