package org.se.lab.metamodel;

public class MParameter
	extends MTypedElement
{
	/*
	 * Constructor
	 */
	public MParameter(String name, MType type)
	{
		super(name,type);
	}

	// Model Validation
	public void validate()
	{
		// validate
		checkIdentifier();

		// navigate
		getType().validate();
	}
}
