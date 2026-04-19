package edu.ces.core;
import java.util.ArrayList ;
import java.util.List;

public class Lecturer extends User
{
    private List<Course> teachingCourses;

    public Lecturer(String id, String name)
    {
        super(id, name);
        this.teachingCourses = new ArrayList<>();
    }

    public List<Course> getTeachingCourses()
    {
        return teachingCourses;
    }
}

