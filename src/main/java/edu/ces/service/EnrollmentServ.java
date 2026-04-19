package edu.ces.service;
import edu.ces.core.Course;
import edu.ces.core.Student;

//This is the logical Brain includes enroll and drop out along with clash detection
public class EnrollmentServ
{
    public boolean enroll(Student student, Course course)
    {
        if (student.getEnrolledCourses().contains(course)) //if enrolled, print string and return false
        {
            System.out.println("Student is already enrolled in this course.");
            return false;
        }

        if (course.isFull()) // capacity check
        {
            System.out.println("Course is full.");
            return false;
        }

        //if not clashed nor full, enroll the student and course register the student
        student.addCourse(course);
        course.addStudent(student);

        System.out.println("You are now enrolled");
        return true;
    }

    public boolean drop(Student student, Course course)
    {
        if(!student.getEnrolledCourses().contains(course))
        {
            System.out.println("You are not in this course");//check if you are in the course
            return false;
        }

        //drop the student out and unregister the student
        student.dropCourse(course);
        course.removeStudent(student);

        System.out.println("You are now removed from this course");
        return true;
    }
}
