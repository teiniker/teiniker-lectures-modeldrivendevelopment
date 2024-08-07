package org.se.lab.metamodel;

public abstract class MNamedElement
	implements ModelValidator
{
	/*
	 * Constructor
	 */
	public MNamedElement(String name)
	{
		setName(name);
	}
	
	
	/*
	 * Property: name:String
	 */
	private String name;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
