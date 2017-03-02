package org.se.lab;

public class IntegerHolder
{
    /*
     * Constructor
     */
	
	public IntegerHolder(Integer value)
	{
		setValue(value);
	}
	
	
	/*
     * Property: value:Integer
     */
	private Integer value;
	public Integer getValue()
	{
		return value;
	}
	public void setValue(Integer value)
	{
	    if(value == null)
            throw new NullPointerException();
		this.value = value;
	}
	
	
	/*
     * Object methods
     */
	public String toString()
	{
		return value.toString();
	}
}
