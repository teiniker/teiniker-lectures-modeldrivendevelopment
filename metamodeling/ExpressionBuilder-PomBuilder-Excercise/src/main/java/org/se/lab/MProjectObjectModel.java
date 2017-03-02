package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class MProjectObjectModel
	extends MCoordinates
{
	/*
	 * Property: packaging:String
	 */
	private String packaging;
	public String getPackaging()
	{
		return packaging;
	}
	public void setPackaging(String packaging)
	{
		this.packaging = packaging;
	}


	/*
	 * Reference: ---[*]-> MDependency
	 */
	private List<MDependency> dependencies = new ArrayList<MDependency>();
	public List<MDependency> getDependencies()
	{
		return dependencies;
	}
	public void setDependencies(List<MDependency> dependencies)
	{
		this.dependencies = dependencies;
	}
}
