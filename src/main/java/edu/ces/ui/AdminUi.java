package edu.ces.ui;
import edu.ces.core.*;
import edu.ces.service.SysState;
import java.util.Scanner;

//most complicated and oversight UserInterface
public class AdminUi
{
    private SysState st;
    private Admin admin;

    public AdminUi(SysState st, Admin admin)
    {
        this.st = st;
        this.admin = admin;
    }

    //Using Step-down rule, helper methods will be placed below the entry method.
    public void start()
    {
        Scanner sc = new Scanner(System.in);

        String menu = "\n"
                +"\n1.View Users"
                +"\n2.Add User"
                +"\n3.Create Course"
                +"\n4.Assign Lecturer to Course"
                +"\n5.View Courses"
                +"\n6.Exit";

        System.out.println("\n"+"Kia ora Administrator, Welcome to the Course Enroll System.");

        while(true)
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

            //menu selector
            switch(num)
            {
                case 1:
                    viewUsers();
                    break;
                case 2:
                    addUser(sc);
                    break;
                case 3:
                    createCourse(sc);
                    break;
                case 4:
                    assignLecturer(sc);
                    break;
                case 5:
                    viewCourses();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Please enter a number on menu.");

            }
        }

    }

    //view overall user method
    private void viewUsers()
    {
        for(User u: st.userServ.getAllUsers())
        {
            //display in specific format
            System.out.println(u.getId()+ " -- "+u.getName()+" ( "+u.getClass().getSimpleName()+" )");
        }
    }

    //create user
    private void addUser(Scanner sc)
    {
        System.out.print("Enter ID: ");
        String id = sc.nextLine().trim();

        if(id.isEmpty())
        {
            System.out.println("ID cannot be empty.");
            return;
        }

        //id checker
        if(st.userServ.findById(id)!=null)
        {
            System.out.println("User already exists");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("User type: \n1.Student \n2.Lecturer \n3.Admin");
        int utype = Integer.parseInt(sc.nextLine());

        User user;

        switch (utype)
        {
            case 1:
                user = new Student(id,name);
                break;
            case 2:
                user = new Lecturer(id,name);
                break;
            case 3:
                user = new Admin(id,name);
                break;
                //failsafe
            default:
                System.out.println("Invalid type");
                return;

        }

        //commit
        st.userServ.addUser(user);
        System.out.println("User added.");
    }

    //addCourse to the list
    private void createCourse(Scanner sc)
    {
        System.out.print("Course ID: ");
        String id = sc.nextLine();

        System.out.print("Course Name: ");
        String name = sc.nextLine();

        System.out.print("Capacity: ");
        int capacity = Integer.parseInt(sc.nextLine());

        //commit
        Course course = new Course(id,name,capacity);
        st.courseServ.addCourse(course);
        System.out.println("Course created.");

    }

    private void viewCourses()
    {
        for (Course c: st.courseServ.getAllCourses())
        {
            //list,check if there's lecturer and use the name, else if print None.
            String lecName = (c.getLecturer()!=null) ? c.getLecturer().getName() : "None";
            System.out.println(c.getCourseId()+" "+c.getCourseName()+ " Lecturer: "+lecName);
        }
    }

    private void assignLecturer(Scanner sc)
    {
        //calls viewCourses method to display all courses
        viewCourses();

        System.out.print("Enter course ID: ");
        String courseId = sc.nextLine().trim();

        Course course = st.courseServ.findCourseById(courseId);
        if(course == null)
        {
            System.out.println("Course ID invalid");
            return;
        }

        //calls viewUsers to display all users
        viewUsers();

        System.out.print("Enter lecturer ID: ");
        String lecId = sc.nextLine().trim();

        User user = st.userServ.findById(lecId);

        //check if type is correct
        if(!(user instanceof Lecturer))
        {
            System.out.println("Invalid Lecturer ID");
            return;
        }

        Lecturer lecturer = (Lecturer) user;

        //commit on both side
        course.setLecturer(lecturer);
        lecturer.getTeachingCourses().add(course);

        System.out.println("Lecturer assigned.");

    }


}
