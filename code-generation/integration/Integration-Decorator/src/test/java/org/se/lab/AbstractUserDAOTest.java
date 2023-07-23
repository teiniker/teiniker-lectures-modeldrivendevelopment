package org.se.lab;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;


public abstract class AbstractUserDAOTest
{
    protected UserDAO dao;
    
    protected void createTable()
    {
        Sequence.init(100);
        dao.insert(new User("homer", "********"));
        dao.insert(new User("bart", "********"));
        dao.insert(new User("lisa", "********"));
    }

    
    @After
    public void teardown()
    {
        // remove all Users from the table
        UserDAOInMemoryImpl.clear();
    }
    
    
    @Test
    public void testFindById()
    {
        User user = dao.findById(101);
        
        Assert.assertEquals("bart", user.getUsername());
        Assert.assertEquals("********", user.getPassword());
        Assert.assertEquals("101,bart,********", user.toString());
    }
    
    @Test
    public void testFindAll()
    {
        List<User> users = dao.findAll();
        
        Assert.assertEquals(3,users.size());
        Assert.assertEquals("homer", users.get(0).getUsername());
        Assert.assertEquals("bart", users.get(1).getUsername());
        Assert.assertEquals("lisa", users.get(2).getUsername());        
    }
    
    @Test
    public void testUpdate()
    {
        User newBart = new User(101, "BART", "********");
        dao.update(newBart);

        Assert.assertEquals("101,BART,********", dao.findById(101).toString());
    }
}
