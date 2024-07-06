package org.se.lab.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MState
{
	/*
	 * Constructors
	 */
	public MState(String name)
	{
		setName(name);
	}
	
	
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
	 * Association: --[*]-> MTransitions
	 */
	private List<MTransition> transitions = new ArrayList<MTransition>();
	public List<MTransition> getTransitions()
	{
		return transitions;
	}
	public void setTransition(List<MTransition> transitions)
	{
		this.transitions = transitions;
	}
	
}
