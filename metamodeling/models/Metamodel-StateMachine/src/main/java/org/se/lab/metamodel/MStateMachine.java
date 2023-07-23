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
		if (states == null)
			throw new IllegalArgumentException("Illegal Argument: states must not be null!");
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
		if (initState == null)
			throw new IllegalArgumentException("Illegal Argument: initState must not be null!");
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
		if (finalStates == null)
			throw new IllegalArgumentException("Illegal Argument: finalState must not be null!");
		this.finalStates = finalStates;
	}
}
