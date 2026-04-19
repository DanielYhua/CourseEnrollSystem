package edu.ces.core;
import java.io.Serializable;

public class Admin extends User implements Serializable
{
    public Admin(String id, String name)
    {
        super(id,name);
    }

    private static final long serialVersionUID = 1L;
}
