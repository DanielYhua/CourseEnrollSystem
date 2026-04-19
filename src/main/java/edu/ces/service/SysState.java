package edu.ces.service;
//import edu.ces.core.Course;

import java.io.Serializable;

//Central controlCheck to avoid dupeLists
public class SysState implements Serializable
{
    private static final long serialVersionUID = 1L;
    public UserServ userServ = new UserServ();
    public CourseServ courseServ = new CourseServ();
    public EnrollmentServ enrollmentServ = new EnrollmentServ();
    public GradeServ gradeServ = new GradeServ();
}
