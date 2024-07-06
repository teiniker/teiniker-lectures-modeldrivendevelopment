package org.se.lab.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MStateMachine
{
	/*
	 * Constructor
	 */
	public MStateMachine()
	{
	}
	
	/*
	 * Association: --[1]-> MState
	 */
	private List<MState> states = new ArrayList<MState>();
	public List<MState> getStates()
	{
		return states;
	}
	public void setStates(List<MState> states)
	{
		this.states = states;
	}
	
	
	/*
	 * Association: --[1]-> MState
	 */
	private MState initState;
	public MState getInitState()
	{
		return initState;
	}
	public void setInitState(MState initState)
	{
		this.initState = initState;
	}
	
	
	/*
	 * Association: --[*]-> MState
	 */
	private List<MState> finalStates = new ArrayList<MState>();
	public List<MState> getFinalStates()
	{
		return finalStates;
	}
	public void setFinalState(List<MState> finalStates)
	{
		this.finalStates = finalStates;
	}
}
