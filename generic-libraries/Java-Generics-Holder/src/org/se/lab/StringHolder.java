package org.se.lab;

public class StringHolder
{	
	/*
	 * Constructor
	 */
    
    public StringHolder(String value)
	{
		setValue(value);
	}
	
	
	/*
	 * Property: value:String
	 */
	private String value;
	public String getValue()
	{
		return value;
	}	
	public void setValue(String value)
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
