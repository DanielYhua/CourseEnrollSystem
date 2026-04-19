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

        //test 2
        SysState st = new SysState();

        //default users and courses
        Student s1 = new Student("s1","Daniel" );
        st.userServ.addUser(s1);

        Course c1 = new Course("COMP100","Intro to Prog",10);
        Course c2 = new Course("COMP101","Java",10);
        st.courseServ.addCourse(c1);
        st.courseServ.addCourse(c2);

        //Mock Login Handler
        Scanner sc = new Scanner(System.in);
        SecurityServ sec = new SecurityServ(st.userServ);

        //Prompt
        System.out.println("Enter user ID: ");
        String id = sc.nextLine();

        User user = sec.login(id);

        if (user == null)
        {
            System.out.println("User not found");
            return;
        }

        System.out.println("Welcome "+ user.getName());

        //to userUi after login as student
        if(user instanceof Student)
        {
            new StudentUi(st, (Student) user).start();
        }

    sc.close();

    }
}
