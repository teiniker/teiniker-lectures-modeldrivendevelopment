package org.se.lab;

public class MHead
{
	/*
	 * Contructor
	 */
	public MHead(String title)
	{
		setTitle(title);
	}
	
	
	/*
	 * Attribute: title:String
	 */
	private String title;
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{		
		this.title = title;
	}	
}
