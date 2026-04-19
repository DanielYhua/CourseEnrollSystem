package edu.ces.core;
import java.util.ArrayList;
import java.util.List;

public class Student extends User
{
    private List<Course> enrolledCourses;
    private List<Grade> grades = new ArrayList<>();

    public Student(String id,String name)
    {
        super(id,name); //super
        this.enrolledCourses = new ArrayList<>(); //using arraylist and list instead fo Array.
    }

    //Course Storage
    public List<Course> getEnrolledCourses()
    {
        return enrolledCourses;
    }

    public void addCourse(Course course)
    {
        enrolledCourses.add(course);
    }

    public void dropCourse(Course course)
    {
        enrolledCourses.remove(course); //using remove instead of drop for global ease of use.
    }

    //Grade Storage
    public void addGrade(Grade grade)
    {
        grades.add(grade);
    }

    public List<Grade> getGrades()
    {
        return grades;
    }
}
