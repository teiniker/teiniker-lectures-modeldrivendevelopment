package org.se.lab;

import org.junit.Before;


public class UserDAODecoratorlTest
    extends AbstractUserDAOTest
{
    @Before
    public void setup()
    {
        dao = new UserDAODecorator(new UserDAOInMemoryImpl());        
        createTable();
    }
}
