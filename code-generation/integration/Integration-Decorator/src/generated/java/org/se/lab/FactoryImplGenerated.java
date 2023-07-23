package org.se.lab;

class FactoryImplGenerated
    extends FactoryImpl
{

    @Override
    public UserDAO createUserDAO()
    {
        return new UserDAOLoggingDecorator(new UserDAOMonitoringDecorator(new UserDAOInMemoryImpl()));
    }
}
