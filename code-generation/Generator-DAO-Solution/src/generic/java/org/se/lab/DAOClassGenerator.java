package org.se.lab;

import org.se.lab.metamodel.MEntity;
import org.se.lab.metamodel.MProperty;


public class DAOClassGenerator
	extends DAOGenerator
{
	@Override
	public void visit(MEntity entity)
	{
		String name = entity.getName();
		code.append("package ").append(getPackageName()).append(";\n\n");
		code.append("import javax.persistence.EntityManager;\n\n");
		
		code.append("abstract class ").append(name).append("DAOImplBase\n");
		code.append("\textends DAOImplTemplate<").append(name).append(">\n");
		code.append("\timplements ").append(name).append("DAO\n");
		code.append("{\n");
		
		// Constructor
		code.append("\tpublic ").append(name).append("DAOImplBase(EntityManager em)\n");
		code.append("\t{\n");
		code.append("\t\tsuper(em);\n");
		code.append("\t}\n\n");

		// getEntityClass()
		code.append("\t@Override\n");
		code.append("\tprotected Class<").append(name).append("> getEntityClass()\n");
		code.append("\t{\n");
		code.append("\t\treturn ").append(name).append(".class;\n");
		code.append("\t}\n\n");
		
		// Factory method
		code.append("\t@Override\n");
		code.append("\tpublic ").append(name).append(" create").append(name).append("(");
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
		code.append(")\n");
		code.append("\t{\n");
		code.append("\t\t").append(name).append(" e = new ").append(name).append("();\n");
		for(int i=0; i< entity.getProperties().size(); i++)
		{
			MProperty p = entity.getProperties().get(i);
			if(p.isId())
				continue;
			code.append("\t\te.set");
			generatePropertyName(p.getName());
			code.append("(").append(p.getName()).append(");\n");
		}
		
		code.append("\t\tinsert(e);\n");
		code.append("\t\treturn e;\n");
		code.append("\t}\n");
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
