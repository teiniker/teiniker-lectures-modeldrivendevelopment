package org.se.lab;

import org.junit.Test;
import org.se.lab.LoggingDecorator;
import org.se.lab.User;
import org.se.lab.UserDAO;
import org.se.lab.UserDAOStub;


public class DynamicProxyTest
{
	@Test
	public void testDynamicProxy()
	{
		UserDAO dao = (UserDAO)LoggingDecorator.newInstance(new UserDAOStub());		
		dao.insert(new User("egon"));
		dao.findById(1);
	}	
}
