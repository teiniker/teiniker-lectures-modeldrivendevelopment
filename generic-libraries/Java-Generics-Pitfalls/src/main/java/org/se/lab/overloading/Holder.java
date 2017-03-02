package org.se.lab.overloading;

/**
 * This GenericHolder class is an example of a generic type declaration. 
 * The type variable T is known as the parameter type of the generic
 * declaration.
 */
public class Holder<T>
{
	private T value;
	
	public Holder(T value)
	{
		setValue(value);
	}
	
	
	public T getValue()
	{
		return value;
	}
	
	public void setValue(T value)
	{
		this.value = value;
	}
	
	
	public String toString()
	{
		return value.toString();
	}
}
