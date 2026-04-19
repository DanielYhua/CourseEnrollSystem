package edu.ces.core;

//note: watchout for scope
public class Grade
{
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
}
