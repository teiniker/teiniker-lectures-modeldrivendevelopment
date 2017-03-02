package org.se.lab;

import org.se.lab.metamodel.MEntity;
import org.se.lab.metamodel.MInteger;
import org.se.lab.metamodel.MProperty;
import org.se.lab.metamodel.MString;
import org.se.lab.metamodel.MType;


public class JavaBeanGenerator 
    implements Visitor
{
    public String toJava(MEntity entity)
    {
        return visitMEntity(entity);
    }
       
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
		return "String";
	}
	
	public String visitMProperty(MProperty property)
	{		
		String accessorName = generatePropertyName(property.getName());
		String javaType = visitMType(property.getType());
		
		StringBuilder code = new StringBuilder();
        code.append("    /*\n");
        code.append("     * Property: " + property.getName() + "\n");
        code.append("     */\n");
        code.append("    private " + javaType + " " + property.getName() + ";\n");
        code.append("    public void set" + accessorName + "(");
        code.append(javaType + " " + property.getName() + ")\n");
        code.append("    {\n");
        code.append("        this." + property.getName() + " = " + property.getName() + ";\n");
        code.append("    }\n");
            
        code.append("    public " + javaType + " get" + accessorName + "()\n");
        code.append("    {\n");
        code.append("        return " + property.getName() + ";\n");
        code.append("    }\n");
        code.append("\n");		
		return code.toString();	
	}
	
	public String visitMEntity(MEntity entity)
	{
		StringBuilder code = new StringBuilder();

		code.append("/*\n");
	    code.append(" * This file was automatically generated\n");
	    code.append(" *  DO NOT EDIT!\n");
	    code.append(" */\n\n");
	    code.append("public class " + entity.getName() + "\n");
	    code.append("{\n");
	    code.append("    public " + entity.getName() + "()\n");
	    code.append("    {\n");
	    code.append("         // default constructor\n");
	    code.append("    }\n\n");
	    for(MProperty p : entity.getProperties())
	    {
	        code.append(visitMProperty(p));
	    }
	    code.append("}\n");	        
	    return code.toString();
	}	
	
	
	/*
	 * Helper Methods
	 */

	public String generatePropertyName(String property)
	{
		StringBuilder s = new StringBuilder();
		s.append(property.substring(0,1).toUpperCase()).append(property.substring(1));
		return s.toString();
	}	
}
