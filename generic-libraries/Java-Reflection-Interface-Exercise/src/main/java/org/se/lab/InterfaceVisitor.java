package org.se.lab;

import java.lang.reflect.Method;
import java.util.Map;

public interface InterfaceVisitor
{
	void visit(Class<?> clazz);
	void visit(Method method);
	
	Map<String, Boolean> getOperationMap();
}