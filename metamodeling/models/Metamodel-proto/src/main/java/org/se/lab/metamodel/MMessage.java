package org.se.lab.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MMessage
	extends MNamedElement
{
	/*
	 * Constructor
	 */
	public MMessage(String name)
	{
		setName(name);
	}
	
	
	/*
	 * Reference: ---[*]-> fields:MField[*]
	 */
	private List<MField> fields = new ArrayList<>();
	public List<MField> getFields()
	{
		return fields;
	}
	public void setProperties(List<MField> fields)
	{
		this.fields = fields;
	}

	/*
	 * Model Validation
	 */
	@Override
	public void validate()
	{
		// Validation
		if(getName() == null || getName().trim().length() == 0)
			throw new IllegalStateException("MMessage: Invalid name: " + getName());

		// Navigation
		getFields().forEach(Validation::validate);
	}
}
