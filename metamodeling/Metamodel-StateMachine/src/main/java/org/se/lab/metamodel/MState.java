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
		if (name == null)
			throw new IllegalArgumentException("Illegal Argument: name must not be null!");
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
		if (transitions == null)
			throw new IllegalArgumentException("Illegal Argument: transitions must not be null!");
		this.transitions = transitions;
	}
	
}
