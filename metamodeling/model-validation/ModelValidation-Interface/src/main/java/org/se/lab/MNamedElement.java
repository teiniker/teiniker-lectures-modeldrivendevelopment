package org.se.lab;

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

	// Model Validation
	public void checkIdentifier()
	{
		if (name == null || name.trim().length() == 0)
			throw new IllegalStateException("Invalid identifier " + name + " at " + this.getClass().getName());
	}
}