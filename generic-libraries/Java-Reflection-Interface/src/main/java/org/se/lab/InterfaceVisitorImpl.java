package org.se.lab;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class InterfaceVisitorImpl 
	implements InterfaceVisitor
{
    private Map<String, Boolean> operations = new HashMap<>(); 
    
    public Map<String, Boolean> getOperationMap()
    {
        return operations;
    }
    
    public void visit(Class<?> clazz)
    {
        Method[] methods = clazz.getDeclaredMethods();        
        for(Method m : methods)
        {
            visit(m);
        }
    }
    
    public void visit(Method m)
    {
        String name = m.getName();
        boolean isTransactional = m.isAnnotationPresent(Transactional.class);
        
        operations.put(name, isTransactional);
    }
}
