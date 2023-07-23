package org.se.lab.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MEntity 
	extends MNamedElement
{
	/*
	 * Constructor
	 */
	public MEntity(String name)
	{
		setName(name);
	}
	
	
	/*
	 * Reference: ---[*]-> properties:MProperty[*]
	 */
	private List<MProperty> properties = new ArrayList<MProperty>();
	public List<MProperty> getProperties()
	{
		return properties;
	}
	public void setProperties(List<MProperty> properties)
	{
		if(properties == null)
			throw new IllegalArgumentException();
		this.properties = properties;
	}	
}
