package org.se.lab.metamodel;

public abstract class MNamedElement
	implements Validation
{
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
