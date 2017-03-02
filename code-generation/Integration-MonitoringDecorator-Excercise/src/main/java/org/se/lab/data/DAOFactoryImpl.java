package org.se.lab.data;

import java.sql.Connection;

import org.apache.log4j.Logger;

public class DAOFactoryImpl
	implements DAOFactory 
{
    private final Logger logger = Logger.getLogger(DAOFactoryImpl.class);

	public UserDAO createUserDAO(Connection connection)
	{
        logger.debug("createUserDAO(" + connection +")");
        
		UserDAO dao = new UserDAOImpl(connection);		
		return dao;
	}
}
