package org.se.lab.data;

import java.sql.Connection;

public interface DAOFactory
{
	UserDAO createUserDAO(Connection connection);
}
