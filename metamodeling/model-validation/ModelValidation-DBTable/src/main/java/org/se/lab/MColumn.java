package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class MColumn extends MNamedElement
{
	/*
	 * Constructor
	 */
	public MColumn(String name)
	{
		super(name);
	}

	
	/*
	 * Reference: ---[1]-> MType
	 */
	private MType type;
	public MType getType()
	{
		return type;
	}
	public void setType(MType type)
	{
		this.type = type;
	}
	
	
	/*
	 * Reference: ---[*]-> MConstraint
	 */
	private List<MConstraint> constraints = new ArrayList<MConstraint>();
	public List<MConstraint> getConstraints()
	{
		return constraints;
	}
	public void setConstraints(List<MConstraint> constraints)
	{
		this.constraints = constraints;
	}

	// Model Validation
	public void validate()
	{
		// validate

		// navigate
		getConstraints().forEach(c -> c.validate());
	}
}
