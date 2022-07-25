package org.se.lab.metamodel;

import java.util.Arrays;
import java.util.List;

public class EntityValidator 
	implements EntityVisitor
{
	private static final List<String> KEY_WORDS = 
			Arrays.asList("abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
					"const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally",
					"float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long",
					"native", "new", "package", "private", "protected", "public", "return", "short", "static",
					"strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try",
					"void", "volatile", "while");
	
	private boolean hasId = false;
	
	
	@Override
	public void visit(MEntity entity)
	{
		if(KEY_WORDS.contains(entity.getName()))
			throw new IllegalStateException("Entity.name is a keyword: " + entity.getName());	

		for(MProperty p : entity.getProperties())
		{
			visit(p);
		}
	}

	
	@Override
	public void visit(MProperty property)
	{
		if(KEY_WORDS.contains(property.getName()))
			throw new IllegalStateException("MProperty.name is a keyword: " + property.getName());	
	
		if(property.isId())
		{
			if(hasId)
				throw new IllegalStateException("MProperty.id is set more than once");
			else
				hasId = true;
		}
		
		// Note that there are no checks in this example but in general, we have
		// to visit all nodes of the model.
		visit(property.getType());
	}

	
	@Override
	public void visit(MType type)
	{
		if(type instanceof MString)
		{
			visit((MString)type);
		}
		else if(type instanceof MInteger)
		{
			visit((MInteger)type);
		}
	}

	
	@Override
	public void visit(MString string)
	{
		// do nothing
	}

	
	@Override
	public void visit(MInteger integer)
	{
		// do nothing
	}
}
