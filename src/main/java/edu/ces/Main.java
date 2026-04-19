package edu.ces;
import edu.ces.core.*;
import edu.ces.service.*;
import edu.ces.ui.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    static void main(String[] args)
    {
        IO.println(String.format("Hello and welcome!"));
        //test 1:
        /*
        Student s = new Student("s1","Daniel");
        Course c = new Course("COMP400","Intro to Java",10);

        s.addCourse(c);
        c.addStudent(s);

        System.out.println(s.getName()+" is enrolled in "+c.getCourseName());
        */

        //dummy data
        DataServ ds = new DataServ();
        SysState st = ds.load();

        //default users and courses
        Student s1 = new Student("s1","Daniel" );
        st.userServ.addUser(s1);
        Lecturer l1 = new Lecturer("l1","Dr.Li");
        st.userServ.addUser(l1);
        Admin a1 = new Admin("a1","Admin");
        st.userServ.addUser(a1);

        Course c1 = new Course("COMP100","Intro to Prog",10);
        Course c2 = new Course("COMP101","Java",10);
        st.courseServ.addCourse(c1);
        st.courseServ.addCourse(c2);

        //assign lecturer to courses
        c1.setLecturer(l1);
        l1.getTeachingCourses().add(c1);

        //Main logic: Login Handler
        Scanner sc = new Scanner(System.in);
        SecurityServ sec = new SecurityServ(st.userServ);

        //Main logic : Prompt
        while (true)
        {
            System.out.println("Enter user ID/'exit': ");
            String id = sc.nextLine();

            if(id.equals("exit"))
            {
                ds.save(st);
                break;
            }

            User user = sec.login(id);

            if (user == null)
            {
                System.out.println("User not found");
                continue;//do not let it exit the program.
            }

            System.out.println("Welcome "+ user.getName());

            //to userUi after login as student,Lecturer or Admin
            if(user instanceof Student)
            {
                new StudentUi(st, (Student) user).start();
            }

            if(user instanceof Lecturer)
            {
                new LecturerUi(st, (Lecturer) user).start();
            }

            if(user instanceof Admin)
            {
                new AdminUi(st, (Admin) user).start();
            }

            System.out.println("Logged-out.");

            //sc.close();
        }













    }
}
