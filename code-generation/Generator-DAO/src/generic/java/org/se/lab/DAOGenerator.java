package org.se.lab;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.se.lab.metamodel.MEntity;
import org.se.lab.metamodel.MInteger;
import org.se.lab.metamodel.MProperty;
import org.se.lab.metamodel.MString;
import org.se.lab.metamodel.MType;

public abstract class DAOGenerator
	implements EntityVisitor
{
	protected StringBuilder code;
	
	public DAOGenerator()
	{
		code = new StringBuilder();
	}
	
	public String generate(MEntity entity, String packageName)
	{
		generateComment();
		setPackageName(packageName);
		visit(entity);
		return code.toString();
	}
	
	public void writeCodeTo(MEntity entity, String packageName, String filename, String path)
	{
		String s = generate(entity, packageName);		
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path, filename)))) 
		{
		    writer.write(s, 0, s.length());
		} 
		catch (IOException e) 
		{
			throw new IllegalStateException("Can't write " + filename + " to " + path + "!", e);
		}
	}
	
	
	/*
	 * Property: packageName
	 */
	private String packageName;
	public String getPackageName()
	{
		return packageName;
	}
	public void setPackageName(String packageName)
	{
		if(packageName == null)
			throw new IllegalArgumentException("Package name is null!");
		this.packageName = packageName;
	}

	public void generateComment()
	{
		Date now = new Date();
		code.append("// This file has been generated automatically at ");
		code.append(now).append("\n");
		code.append("// Don't modify it manually!\n\n");
	}
	
	public void generatePropertyName(String name)
	{
		code.append(Character.toUpperCase(name.charAt(0)));
		code.append(name.substring(1,name.length()));		
	}
	
	
	@Override
	public void visit(MEntity entity)
	{
		// code generation
		
		// navigation
		for(MProperty p : entity.getProperties())
		{
			visit(p);
		}
	}

	@Override
	public void visit(MProperty property)
	{
		// code generation
		
		// navigation
		visit(property.getType());
	}

	@Override
	public void visit(MType type)
	{
		// navigation
		if(type instanceof MInteger)
		{
			visit((MInteger)type);
		}
		else if(type instanceof MString)
		{
			visit((MString)type);
		}
		else
		{
			throw new IllegalStateException("Unknown MType!");
		}		
	}

	@Override
	public void visit(MInteger i)
	{
		// code generation
		code.append("int");
	}

	@Override
	public void visit(MString s)
	{
		// code generation
		code.append("String");		
	}
}
