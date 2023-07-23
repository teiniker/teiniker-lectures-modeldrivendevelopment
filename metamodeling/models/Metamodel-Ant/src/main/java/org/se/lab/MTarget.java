package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class MTarget
	extends MNamedElement
{

	/*
	 * Reference: ---[*]-> tasks
	 */
	private List<MTask> tasks = new ArrayList<MTask>();
	public List<MTask> getTasks()
	{
		return tasks;
	}
	public void setTasks(List<MTask> tasks)
	{
		this.tasks = tasks;
	}
	
	
	/*
	 * Reference: ---[*]-> dependencies
	 */
	private List<MTarget> dependencies = new ArrayList<MTarget>();
	public List<MTarget> getDependencies()
	{
		return dependencies;
	}
	public void setDependencies(List<MTarget> dependencies)
	{
		this.dependencies = dependencies;
	}
	
}
