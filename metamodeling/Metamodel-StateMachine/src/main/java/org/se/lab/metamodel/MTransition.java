package org.se.lab.metamodel;

public class MTransition
{
	/*
	 * Constructor
	 */
	public MTransition(String trigger, String activity)
	{
		setTrigger(trigger);
		setActivity(activity);
	}
	
	/*
	 * Property: trigger:String
	 */
	private String trigger;
	public String getTrigger()
	{
		return trigger;
	}
	public void setTrigger(String trigger)
	{
		if (trigger == null)
			throw new IllegalArgumentException("Illegal Argument: trigger must not be null!");
		this.trigger = trigger;
	}
	
	/*
	 * Property: activity:String
	 */
	private String activity;
	public String getActivity()
	{
		return activity;
	}
	public void setActivity(String activity)
	{
		if (activity == null)
			throw new IllegalArgumentException("Illegal Argument: activity must not be null!");
		this.activity = activity;
	}
	
	/*
	 * Association: --[1]-> MState
	 */
	private MState target;
	public MState getTarget()
	{
		return target;
	}
	public void setTarget(MState target)
	{
		if (target == null)
			throw new IllegalArgumentException("Illegal Argument: target must not be null!");
		this.target = target;
	}
}
