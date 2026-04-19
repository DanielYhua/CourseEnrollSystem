package edu.ces.service;
//import edu.ces.core.Course;

//Central controlCheck to avoid dupeLists
public class SysState
{
    public UserServ userServ = new UserServ();
    public CourseServ courseServ = new CourseServ();
    public EnrollmentServ enrollmentServ = new EnrollmentServ();
    public GradeServ gradeServ = new GradeServ();
}
