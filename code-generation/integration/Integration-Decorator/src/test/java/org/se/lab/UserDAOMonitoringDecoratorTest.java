package org.se.lab;

import org.junit.Before;


public class UserDAOMonitoringDecoratorTest
    extends AbstractUserDAOTest
{
    @Before
    public void setup()
    {
        dao = new UserDAOMonitoringDecorator(new UserDAOInMemoryImpl());        
        createTable();
    }
}
