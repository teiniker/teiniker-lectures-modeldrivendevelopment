package org.se.lab;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

public class LoggingDecorator 
	implements InvocationHandler
{
	private Object impl;
	private LoggingDecorator(Object impl)
	{
		this.impl = impl;
	}

	// Static creation method
	public static Object newInstance(Object impl)
	{
		return Proxy.newProxyInstance(
				impl.getClass().getClassLoader(),
				impl.getClass().getInterfaces(),
				new LoggingDecorator(impl));
	}

	// Handle method invocations
	@Override
	public Object invoke(Object proxy, Method m, Object[] args)
		throws IllegalArgumentException
	{
		try
		{
			System.out.println("[" + new Date() + "] before method: " + m.getName());
			Object  result = m.invoke(impl, args);
			return result;
		}
		catch (InvocationTargetException e)
		{
			throw new IllegalStateException("Can't invoke method: ", e);
		} 
		catch (Exception e)
		{
			throw new IllegalStateException("Unexpected invocation exception: " + e.getMessage());
		}  
		finally
		{
			System.out.println("[" + new Date() + "] after method: " + m.getName());
		}
	}
}
