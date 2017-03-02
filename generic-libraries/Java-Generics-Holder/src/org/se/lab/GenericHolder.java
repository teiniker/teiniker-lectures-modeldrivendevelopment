package org.se.lab;

/**
 * This GenericHolder class is an example of a generic type declaration.
 * The type variable T is known as the parameter type of the generic
 * declaration.
 */
public class GenericHolder<T>
{
    /*
     * Constructor
     */
    
	public GenericHolder(T value)
	{
		setValue(value);
	}

	
	/*
	 * Property: value:T
	 */
	private T value;
	public T getValue()
	{
		return value;
	}
	public void setValue(T value)
	{
	    if(value == null)
	        throw new NullPointerException();
	    this.value = value;
	}


	/*
	 * Object method
	 */
	public String toString()
	{
		return value.toString();
	}
}
