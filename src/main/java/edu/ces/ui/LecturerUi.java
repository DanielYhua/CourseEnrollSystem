package edu.ces.ui;
import edu.ces.core.*;
import edu.ces.service.SysState;
import java.util.Scanner;

public class LecturerUi
{
    private SysState st;
    private Lecturer lec;

    public LecturerUi(SysState st, Lecturer lec)
    {
        this.st = st;
        this.lec = lec;
    }



    //entry point for LecturerUi
    public void start() {
        Scanner sc = new Scanner(System.in);
        String menu = " "
                + "\n1.View My Courses"
                + "\n2.Assign Grade"
                + "\n3.Exit";

        System.out.println("\n");
        System.out.println("Kia ora, " + lec.getName() + " Welcome to the Course Enroll System Menu =====");

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

            switch (num) {
                case 1:
                    viewCourses();
                    break;

                case 2:
                    assignGrade(sc);
                    break;

                case 3:
                    return;
            }
        }
    }

        private void viewCourses()//helper method
        {
            for (Course c: lec.getTeachingCourses())
            {
                System.out.println(c.getCourseId()+" ---> "+c.getCourseName());
            }
        }

        private void assignGrade(Scanner sc)//helper method
        {
            System.out.println("Enter course ID: ");
            String courseId = sc.nextLine().trim();

            Course course = st.courseServ.findCourseById(courseId);

            if (course == null)
            {
                System.out.println("Course not found");
                return;
            }

            System.out.println("Students in your course: ");//using loop to display students' names
            for(Student s: course.getEnrolledStudents())
            {
                System.out.println(s.getId()+" --- "+s.getName());
            }

            System.out.println("Enter student ID: ");
            String studentId = sc.nextLine().trim();

            Student student = (Student) st.userServ.findById(studentId);

            if (student == null)
            {
                System.out.println("Incorrect Id or student not found");
                return;
            }

            System.out.println("Enter grade (A-F): ");
            String grade = sc.nextLine().trim();

            st.gradeServ.assignGrade(student, course, grade);
        }



}
