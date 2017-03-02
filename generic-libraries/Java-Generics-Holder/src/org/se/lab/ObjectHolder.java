package org.se.lab;

public class ObjectHolder
{
    /*
     * Constructor
     */

	public ObjectHolder(Object value)
	{
		setValue(value);
	}
	
	
    /*
     * Property: value:Object
     */
	private Object value;
	public Object getValue()
	{
		return value;
	}
	public void setValue(Object value)
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
