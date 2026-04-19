package edu.ces.service;
import edu.ces.core.*;

public class GradeServ
{
    public void assignGrade(Student student,Course course, String gradeVal)//check entroll first -> check if there's grade in place
    {
        if(!student.getEnrolledCourses().contains(course))
        {
            System.out.println("Student is not in this course.");
            return;
        }

        for (Grade g: student.getGrades())
        {
            if (g.getCourse().equals(course))
            {
                g.setGrade(gradeVal);
                System.out.println("Grade updated");
                return;
            }
        }

        student.addGrade(new Grade(course,gradeVal));
        System.out.println("Grade assigned");

    }
}
