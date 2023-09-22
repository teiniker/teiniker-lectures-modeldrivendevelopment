package org.se.lab.metamodel;

public class MField
	extends MNamedElement
{
	/*
	 * Constructor
	 */
	public MField(String name, int number, MType type)
	{
		setName(name);
		setNumber(number);
		setType(type);		
	}
	
	/*
	 * Property: number:int
	 */
	private int number;
	public int getNumber()
	{
		return number;
	}
	public void setNumber(int number)
	{
		this.number = number;
	}

	/*
	 * Property: type:MType
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
	 * Model Validation
	 */
	@Override
	public void validate()
	{
		// Validation
		if(getName() == null || getName().trim().length() == 0)
			throw new IllegalStateException("MField: Invalid name: " + getName());

		if(getNumber() < 1)
			throw new IllegalStateException("MField: Invalid number: " + getNumber());

		if(getType() == null)
			throw new IllegalStateException("MField: Invalid type: null");

		// Navigation
		getType().validate();
	}
}
