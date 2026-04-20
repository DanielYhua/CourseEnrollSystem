package edu.ces.service;
//import edu.ces.core.Course;

import java.io.Serializable;

//Central controlCheck to avoid dupeLists
public class SysState implements Serializable
{
    private static final long serialVersionUID = 1L;

    public transient UserServ userServ = new UserServ(); //dont serialize
    public transient CourseServ courseServ = new CourseServ(); //dont serialize
    public transient EnrollmentServ enrollmentServ = new EnrollmentServ();//dont serialize
    public transient GradeServ gradeServ = new GradeServ();//dont serialize
}
