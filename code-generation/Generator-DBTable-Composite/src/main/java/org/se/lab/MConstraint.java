package org.se.lab;

public class MConstraint extends MNamedElement
{
	/*
	 * Constructor
	 */
	public MConstraint(String name)
	{
		super(name);
	}
	
	@Override
	public String toSql()
	{
		return getName();
	}
}
