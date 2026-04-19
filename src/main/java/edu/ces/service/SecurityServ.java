package edu.ces.service;
import edu.ces.core.*;
//import java.util.ArrayList;
//import java.util.List;

//Note: this is only a simple login security as for v1 and no database to back up, it is really limited
public class SecurityServ
{
    /*
    private List<User> users = new ArrayList<>();

    public SecurityServ() //default users
    {
        users.add(new Student("S1","Daniel"));
        users.add(new Lecturer("L1","Dr.Li"));
        users.add(new Admin("Admin","Administrator"));
    }

    //no further security check, keep it simple for now
    public User login(String id)
    {
        for (User u : users)
        {
            if(u.getId().equals(id))
            {
                return u;
            }
        }

        return null;

    }
     */

    //Simplified Security
    private UserServ userServ;

    public SecurityServ(UserServ userServ)
    {
        this.userServ = userServ;
    }

    public User login(String id) //login handle
    {
        return userServ.findById(id);
    }
}
