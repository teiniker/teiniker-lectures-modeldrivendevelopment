package org.se.lab;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class EntityVisitorImpl 
	implements EntityVisitor
{
    public String visitEntity(Class<?> clazz)
    {
        if(!clazz.isAnnotationPresent(Entity.class))
            return "";
        
        String name = clazz.getSimpleName();        
        
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("{ ");
        
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields)
        {
            sb.append(visitProberty(field)).append(" ");            
        }
        sb.append("}");
        
        return sb.toString();
    }
        
    public String visitProberty(Field field)
    {
        String name = field.getName();
        String type = visitType(field);
        
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(":").append(type);
        Annotation idAnnotation = field.getAnnotation(Id.class);
        if(idAnnotation != null)
        {
        	sb.append("[id]");
        }
        return sb.toString();
    }
        
    public String visitType(Field field)
    {
    	String typeName = field.getType().getSimpleName();    	
    	return typeName;
    }
}
