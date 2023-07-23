package org.se.lab;

public abstract class MNamedElement
	implements SqlGenerator
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
