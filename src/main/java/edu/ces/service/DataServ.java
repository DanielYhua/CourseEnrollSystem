package edu.ces.service;
import java.io.*;

//Note: this class was coded with AI
public class DataServ
{
    private static final String FILE_NAME = "data.ser";

    public void save(SysState st)
    {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME)))
        {
            out.writeObject(st);
            System.out.println("Data saved.");
        }
        catch (IOException e)
        {
            System.out.println("Save failed.");
            e.printStackTrace(); //for easy debug
        }
    }

    public SysState load()
    {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME)))
        {
            SysState st = (SysState) in.readObject();

            st.enrollmentServ = new EnrollmentServ();
            st.gradeServ = new GradeServ();
            st.courseServ = new CourseServ();
            st.userServ = new UserServ();

            System.out.println("Data loaded.");
            return (SysState) in.readObject();
        }
        catch(Exception e)
        {
            System.out.println("No data found. Initializing.");
            return new SysState();
        }
    }
}
