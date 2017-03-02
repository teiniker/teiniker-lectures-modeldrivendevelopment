package org.se.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class UserDAOInMemoryImpl
    implements UserDAO
{
    /*
     * In memory storage for User Objects
     */
    private static List<User> table = new ArrayList<User>();
    
    public static void clear()
    {
        table.clear();
    }
    
    
    /*
     * UerDAO methods
     */

    public void insert(User user)
    {
        if(user == null)
            throw new IllegalArgumentException();        
        table.add(user);
    }

    public void update(User user)
    {
        int index = table.indexOf(user);
        if(index == -1)
            throw new IllegalStateException("Object doesn't exist!");
        else
            table.set(index, user);
    }

    public void delete(long id)
    {
        for(int i = 0; i < table.size(); i++)
        {
            if(table.get(i).getId() == id)
                table.remove(i);
        }
    }

    public User findById(long id)
    {
        User user = null;
        for(int i = 0; i < table.size(); i++)
        {
            if(table.get(i).getId() == id)
                user = table.get(i);
        }
        return user;
    }

    public List<User> findAll()
    {
        delay(1000); // simulate slow database 
        return Collections.unmodifiableList(table);
    }
    
    
    protected void delay(long millis)
    {
        try
        {
            Thread.sleep(millis);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        
    }
}
