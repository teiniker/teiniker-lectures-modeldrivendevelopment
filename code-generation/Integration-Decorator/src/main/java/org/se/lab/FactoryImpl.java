package org.se.lab;

class FactoryImpl implements Factory
{
    public UserDAO createUserDAO()
    {
        return new UserDAOInMemoryImpl();
    }

}
