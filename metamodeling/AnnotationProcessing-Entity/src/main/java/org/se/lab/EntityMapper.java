package org.se.lab;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.se.lab.metamodel.MEntity;
import org.se.lab.metamodel.MInteger;
import org.se.lab.metamodel.MProperty;
import org.se.lab.metamodel.MString;
import org.se.lab.metamodel.MType;

public class EntityMapper
{
    public MEntity toMEntity(Class<?> clazz)
    {
        if(!clazz.isAnnotationPresent(Entity.class))
            return null;
        
        String name = clazz.getSimpleName();        
        MEntity entity = new MEntity(name);
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields)
        {
            MProperty property = toProberty(field);
            entity.getProperties().add(property);
        }
        return entity;
    }
    
    
    protected MProperty toProberty(Field field)
    {
        String name = field.getName();
        MType type = toMType(field);
        Annotation idAnnotation = field.getAnnotation(Id.class);
        boolean isId;
        if(idAnnotation == null)        	
        	isId = false;
        else
        	isId = true;        
        
        MProperty property = new MProperty(name, type);
        property.setId(isId);
        return property;
    }
    
    
    protected MType toMType(Field field)
    {
    	String typeName = field.getType().getSimpleName();
    	
    	MType type = null;
    	if(typeName.equals("int"))
        	type = new MInteger();
        else if(typeName.equals("String"))
        	type = new MString();

    	return type;
    }
}
