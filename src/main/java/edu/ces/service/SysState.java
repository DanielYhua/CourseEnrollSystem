package edu.ces.service;
//import edu.ces.core.Course;

import java.io.Serializable;

//Central controlCheck to avoid dupeLists
public class SysState implements Serializable
{
    private static final long serialVersionUID = 1L;

    public UserServ userServ = new UserServ(); //serialize
    public CourseServ courseServ = new CourseServ(); //serialize
    public transient EnrollmentServ enrollmentServ = new EnrollmentServ();//dont serialize
    public transient GradeServ gradeServ = new GradeServ();//dont serialize
}
