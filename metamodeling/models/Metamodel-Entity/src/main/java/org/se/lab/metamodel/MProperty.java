package org.se.lab.metamodel;

public class MProperty 
	extends MNamedElement
{
	/*
	 * Constructor
	 */
	public MProperty(String name, MType type)
	{
		setName(name);
		setType(type);		
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
		if(type == null)
			throw new IllegalArgumentException();
		this.type = type;
	}	
	
	
	/*
	 * Property: id:boolean
	 */
	private boolean id;
	public boolean isId()
	{
		return id;
	}
	public void setId(boolean id)
	{
		this.id = id;
	}	
}
