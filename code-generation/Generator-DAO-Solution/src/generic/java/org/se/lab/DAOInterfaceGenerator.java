package org.se.lab;

import org.se.lab.metamodel.MEntity;
import org.se.lab.metamodel.MProperty;


public class DAOInterfaceGenerator
	extends DAOGenerator
{
	@Override
	public void visit(MEntity entity)
	{
		String name = entity.getName();
		code.append("package ").append(getPackageName()).append(";\n\n");
		code.append("public interface ").append(name).append("DAOBase\n");
		code.append("\textends DAOTemplate<").append(name).append(">\n");
		code.append("{\n");
		
		code.append("\t").append(name).append(" create").append(name).append("(");
		for(int i=0; i< entity.getProperties().size(); i++)
		{
			MProperty p = entity.getProperties().get(i);
			if(p.isId())
				continue;
			visit(p);
			if(i < entity.getProperties().size()-1)
			{
				code.append(',');
			}
		}
		code.append(");\n");
		code.append("}\n");
	}

	@Override
	public void visit(MProperty property)
	{
		// id will be generated from the database
		if(!property.isId())
		{
			visit(property.getType());
			code.append(" ").append(property.getName());
		}
	}
}
