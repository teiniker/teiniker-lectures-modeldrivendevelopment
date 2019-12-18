package org.se.lab;

import org.se.lab.metamodel.MEntity;
import org.se.lab.metamodel.MInteger;
import org.se.lab.metamodel.MProperty;
import org.se.lab.metamodel.MString;
import org.se.lab.metamodel.MType;


public class CStructGenerator 
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
		return "int";
	}

	public String visitMString(MString arg)
	{
		return "char*";
	}
	
	public String visitMProperty(MProperty property)
	{		
	    String cType = visitMType(property.getType());
		String name = property.getName();
		
		StringBuilder code = new StringBuilder();
        code.append(cType).append(" ").append(name).append(";");
		return code.toString();	
	}
	
	public String visitMEntity(MEntity entity)
	{
		String name = entity.getName();
	    
		StringBuilder code = new StringBuilder();
	    code.append("typedef struct {\n");
	    for(MProperty p : entity.getProperties())
	    {
	        code.append("    ").append(visitMProperty(p)).append("\n");
	    }
	    code.append("} ").append(name).append(";");	        
	    return code.toString();
	}	
}
