package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class MProject
{
	
	/*
	 * Property: name:String
	 */
	private String name;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	

	/*
	 * Property: baseDir:String
	 */
	private String baseDir;
	public String getBaseDir()
	{
		return baseDir;
	}
	public void setBaseDir(String baseDir)
	{
		this.baseDir = baseDir;
	}

	
	/*
	 * Reference: ---[1]-> MDescription
	 */
	private MDescription description;
	public MDescription getDescription()
	{
		return description;
	}
	public void setDescription(MDescription description)
	{
		this.description = description;
	}
	

	/*
	 * Reference: ---[*]-> MProperty
	 */
	private List<MProperty> properties = new ArrayList<MProperty>();
	public List<MProperty> getProperties()
	{
		return properties;
	}
	public void setProperties(List<MProperty> properties)
	{
		this.properties = properties;
	}


}
