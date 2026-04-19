package edu.ces.core;
import java.util.ArrayList;
import java.util.List;

public class Course
{
    private String courseId;
    private String courseName;
    private int capacity; //important for clash detection
    private List<Student> enrolledStudents;
    private Lecturer lecturer;

    public Course(String courseId, String courseName,int capacity)
    {
        this.courseId = courseId;
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseId()
    {
        return courseId;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public List<Student> getEnrolledStudents()
    {
        return enrolledStudents;
    }

    public boolean isFull()
    {
        return enrolledStudents.size() >= capacity;
    }

    public void addStudent(Student student)
    {
        enrolledStudents.add(student);
    }

    public void removeStudent(Student student) //note: remove not drop
    {
        enrolledStudents.remove(student);
    }

    public void setLecturer(Lecturer lecturer)
    {
        this.lecturer = lecturer;
    }

    public Lecturer getLecturer()
    {
        return lecturer;
    }
}
