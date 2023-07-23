package org.se.lab;

import org.junit.Before;


public class UserDAOInMemoryImplTest
    extends AbstractUserDAOTest
{
    @Before
    public void setup()
    {
        Factory factory = new FactoryImpl();
        dao = factory.createUserDAO();        
        createTable();
    }
}
