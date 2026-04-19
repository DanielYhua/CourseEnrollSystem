package edu.ces.core;

import edu.ces.service.CourseServ;

import java.io.Serializable;

// this is the linking layer, for scalability
public class Enrollment implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Student student;
    private Course course;
    private String status; //to return enrolled or removed/dropped

    public Enrollment(Student student,Course course, String status)
    {
        this.student = student;
        this.course = course;
        this.status = status;
    }

    public Student getStudent()
    {
        return student;
    }

    public Course getCourse()
    {
        return course;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status) //to save the status
    {
        this.status = status;
    }
}
