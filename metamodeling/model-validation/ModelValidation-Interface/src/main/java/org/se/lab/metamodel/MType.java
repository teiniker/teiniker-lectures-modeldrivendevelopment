package org.se.lab.metamodel;

public class MType
	extends MNamedElement
{
	/*
	 * Constructor
	 */
	public MType(String name)
	{
		super(name);
	}

	// Model Validation
	public void validate()
	{
		checkIdentifier();
	}
}
