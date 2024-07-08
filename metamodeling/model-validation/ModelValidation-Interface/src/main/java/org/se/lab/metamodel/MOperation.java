package org.se.lab.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MOperation
	extends MTypedElement
{
	/*
	 * Constructor
	 */
	public MOperation(String name, MType type)
	{
		super(name,type);
	}
	
	
	/*
	 * Reference: ---[*]-> parameters:MParameter[*]
	 */
	private List<MParameter> parameters = new ArrayList<MParameter>();
	public List<MParameter> getParameters()
	{
		return parameters;
	}
	public void setParameters(List<MParameter> parameters)
	{
		this.parameters = parameters;
	}

	// Model Validation
	public void validate()
	{
		// check if the name is invalid regarding upper/lower case
		checkIdentifier();
		if (Character.isUpperCase(getName().charAt(0)))
			throw new IllegalStateException("Invalid naming convention: " + getName());

		// navigate
		getParameters().forEach(o -> o.validate());
	}
}