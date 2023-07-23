package org.se.lab;

public class MHeadline extends MPageElement
{
	/*
	 * Constructor
	 */
	public MHeadline(String text, int level)
	{
		setText(text);
		setLevel(level);
	}
	
	
	/*
	 * Attribute: level:int
	 */
	private int level;
	public int getLevel()
	{
		return level;
	}
	public void setLevel(int level)
	{
		this.level = level;
	}
	
}
