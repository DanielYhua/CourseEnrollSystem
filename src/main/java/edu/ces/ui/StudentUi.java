package edu.ces.ui;
import edu.ces.core.Course;
import edu.ces.core.Grade;
import edu.ces.core.Student;
import edu.ces.service.SysState;
import java.util.Scanner;

//Student UI
public class StudentUi
{
    private SysState st;
    private Student student;

    public StudentUi(SysState st, Student student)
    {
        this.st = st;
        this.student = student;
    }

    private void viewCourses()
    {
        System.out.println("\n Available Courses: ");
        for(Course c: st.courseServ.getAllCourses())
        {
            System.out.println(c.getCourseId()+"--->"+c.getCourseName());
        }
    }

    private void enroll(Scanner sc)
    {
        System.out.print("\nEnter course ID: ");
        String courseID = sc.nextLine().trim();

        Course course = st.courseServ.findCourseById(courseID);

        if (course == null)
        {
            System.out.println("Course not available or found");
            return;
        }

        boolean success = st.enrollmentServ.enroll(student, course);

        if(success)
        {
            System.out.println("Success");
        }
    }

    private void viewGrades()
    {
        for (Grade g: student.getGrades())
        {
            System.out.println(g.getCourse().getCourseName()+" : "+g.getGrade());
        }
    }

    public void start() //entry point for ui
    {
        Scanner sc = new Scanner(System.in);

        String menu = """
                
                1.View Courses\
                
                2.Enroll in Course\
                
                3.View Grades\
                
                4.Exit""";

        System.out.println("\nKia Ora, Welcome to the Course Enroll System Menu======");

        while (true)
        {
            System.out.println(menu);

            String input = sc.nextLine().trim();
            int num;

            try
            {
                num = Integer.parseInt(input);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid, Please enter a number.");
                continue;
            }

            switch (num)
            {
                case 1:
                    viewCourses();
                    break;

                case 2:
                    enroll(sc);
                    break;

                case 3:
                    viewGrades();
                    break;

                case 4:
                    return;
            }
        }
    }
}
