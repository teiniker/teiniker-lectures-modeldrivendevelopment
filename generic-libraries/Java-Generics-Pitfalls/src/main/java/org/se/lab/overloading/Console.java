package org.se.lab.overloading;


public class Console
{
	private String prompt;
	
	public Console(String prompt)
	{
		if(prompt == null)
			throw new NullPointerException();
		
		this.prompt = prompt;
	}

	
	public void print(Holder<Integer> holder)
	{
		if(holder == null)
			throw new NullPointerException();
		
		System.out.println(prompt + holder.toString());
	}

	
	/*
	 * Here we will get a compile time error if we try to overload two
	 * methods based on their generic parameter type. 
	 */
	public void print2(Holder<String> holder)
	{
		if(holder == null)
			throw new NullPointerException();

		System.out.println(prompt + holder.toString());
	}
}
