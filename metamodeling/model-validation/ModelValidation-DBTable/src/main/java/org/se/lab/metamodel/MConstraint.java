package org.se.lab.metamodel;

public class MConstraint extends MNamedElement
{
	private static boolean hasPrimaryKey = false;

	/*
	 * Constructor
	 */
	public MConstraint(String name)
	{
		super(name);
	}

	// Model Validation
	public void validate()
	{
		// validate
		if(getName().equalsIgnoreCase("PRIMARY KEY"))
		{
			if(MConstraint.hasPrimaryKey)
				throw new IllegalStateException("There are more than one primary keys in this table!");
			else
				MConstraint.hasPrimaryKey = true;
		}
	}
}
