package edu.ces.core;

import java.io.Serializable;

//note: watchout for scope
public class Grade implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Course course;
    private String grade;

    public Grade(Course course,String grade)
    {
        this.course = course;
        this.grade = grade;
    }

    public Course getCourse()
    {
        return course;
    }

    public String getGrade()
    {
        return grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }
}
