package org.se.lab;

import org.junit.Test;
import org.se.lab.LoggingDecorator;


public class DynamicProxyTest
{
	@Test
	public void testDynamicProxy()
	{
		UserTable dao = (UserTable)LoggingDecorator.newInstance(new UserTableStub());
		dao.insert(new User("egon"));
		dao.findById(1);
	}	
}
