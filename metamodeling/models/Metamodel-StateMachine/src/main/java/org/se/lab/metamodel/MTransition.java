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
		this.target = target;
	}
}
