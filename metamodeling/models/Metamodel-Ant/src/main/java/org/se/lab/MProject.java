package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class MProject
	extends MNamedElement
{
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
	
	
	/*
	 * Reference: targets
	 */
	private List<MTarget> targets = new ArrayList<MTarget>();
	public List<MTarget> getTargets()
	{
		return targets;
	}
	public void setTargets(List<MTarget> targets)
	{
		this.targets = targets;
	}
	
	
	/*
	 * Property: default
	 */
	private MTarget def;
	public MTarget getDefault()
	{
		return def;
	}
	public void setDefault(MTarget def)
	{
		this.def = def;
	}
	
}
