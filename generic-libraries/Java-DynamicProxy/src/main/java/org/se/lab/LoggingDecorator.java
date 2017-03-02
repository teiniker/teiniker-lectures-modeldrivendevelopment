package org.se.lab;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

public class LoggingDecorator 
	implements java.lang.reflect.InvocationHandler
{
	/*
	 * Static creation method
	 */
	
	private Object impl;

	private LoggingDecorator(Object impl)
	{
		this.impl = impl;
	}

	
	public static Object newInstance(Object impl)
	{
		if(impl == null)
			throw new NullPointerException("impl");

		return Proxy.newProxyInstance(
				impl.getClass().getClassLoader(), 
				impl.getClass().getInterfaces(), 
				new LoggingDecorator(impl));
	}


	/*
	 * Handle method invocation
	 */
	@Override
	public Object invoke(Object proxy, Method m, Object[] args)
		throws Throwable
	{
		Object result;
		try
		{
			System.out.println("[" + new Date() + "] before method: " + m.getName());
			result = m.invoke(impl, args);
		} 
		catch (InvocationTargetException e)
		{
			throw e.getTargetException();
		} 
		catch (Exception e)
		{
			throw new RuntimeException("unexpected invocation exception: "
					+ e.getMessage());
		}  
		finally
		{
			System.out.println("[" + new Date() + "] after method: " + m.getName());
		}
		return result;
	}
}
