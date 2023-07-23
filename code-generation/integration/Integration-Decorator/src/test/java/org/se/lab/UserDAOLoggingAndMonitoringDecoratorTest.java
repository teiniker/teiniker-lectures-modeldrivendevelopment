package org.se.lab;

import org.junit.Before;


public class UserDAOLoggingAndMonitoringDecoratorTest
    extends AbstractUserDAOTest
{
    @Before
    public void setup()
    {
        Factory factory = new FactoryImplGenerated();
        dao = factory.createUserDAO();        
        createTable();
    }
}
