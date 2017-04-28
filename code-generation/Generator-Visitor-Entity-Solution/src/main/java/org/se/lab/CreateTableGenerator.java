package org.se.lab;

import org.se.lab.metamodel.MEntity;
import org.se.lab.metamodel.MInteger;
import org.se.lab.metamodel.MProperty;
import org.se.lab.metamodel.MString;
import org.se.lab.metamodel.MType;


public class CreateTableGenerator 
    implements Visitor
{
	public String visitMType(MType type)
	{
		if(type instanceof MInteger)
		{
			return visitMInteger((MInteger)type);
		}
		else if(type instanceof MString)
		{
			return visitMString((MString)type);
		}
		else
		{	
			throw new IllegalArgumentException("unknoen MType:" + type);
		}
	}

	
	public String visitMInteger(MInteger arg)
	{
		return "INT";
	}

	
	public String visitMString(MString arg)
	{
		return "VARCHAR(256)";
	}

	
	public String visitMProperty(MProperty property)
	{		
	    String type = visitMType(property.getType());
		String name = property.getName();
		
		StringBuilder code = new StringBuilder();
        code.append(name).append(" ").append(type);
        if(property.isId())
        {
            code.append(" PRIMARY KEY");
        }
		return code.toString();	
	}
	
	
	public String visitMEntity(MEntity entity)
	{
		String name = entity.getName();
	    
		StringBuilder code = new StringBuilder();
	    code.append("CREATE TABLE ").append(name).append(" (\n");
	    for(int i = 0; i < entity.getProperties().size(); i++)
	    {
	        MProperty property = entity.getProperties().get(i);
	        String propertyCode = visitMProperty(property);
	        code.append("    ").append(propertyCode);
	        if(i < entity.getProperties().size()-1)
	            code.append(",");
	        code.append("\n");
	    }
	    code.append(");");	        
	    return code.toString();
	}	
}
