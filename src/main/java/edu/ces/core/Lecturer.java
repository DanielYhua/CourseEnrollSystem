package edu.ces.core;
import java.io.Serializable;
import java.util.ArrayList ;
import java.util.List;

public class Lecturer extends User implements Serializable
{
    private static final long serialVersionUID = 1L;
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

