package org.se.lab;

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
