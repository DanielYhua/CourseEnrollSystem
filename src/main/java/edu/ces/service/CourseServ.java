package edu.ces.service;
import edu.ces.core.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseServ
{
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course)
    {
        courses.add(course);
    }

    public List<Course> getAllCourses()
    {
        return courses;
    }

    public Course findCourseById(String id)
    {
        for (Course c : courses)
        {
            if(c.getCourseId().equals(id))
            {
                return c;
            }
        }

        return null;

    }
}
