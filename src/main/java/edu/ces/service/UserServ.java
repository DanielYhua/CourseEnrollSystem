package edu.ces.service;
import edu.ces.core.User;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

//to handle users (admin features)
public class UserServ implements Serializable
{
    private static final long serialVersionUID = 1L;
    private List<User> users = new ArrayList<>();

    public void addUser(User user)
    {
        users.add(user);
    }

    public User findById(String id)
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

    public List<User> getAllUsers()
    {
        return users;
    }

    public void removerUser(String id)
    {
        users.removeIf(u -> u.getId().equals(id));
    }
}
