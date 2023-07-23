package org.se.lab;

import org.junit.Before;


public class UserDAOLoggingDecoratorTest
    extends AbstractUserDAOTest
{
    @Before
    public void setup()
    {
        dao = new UserDAOLoggingDecorator(new UserDAOInMemoryImpl());        
        createTable();
    }
}
