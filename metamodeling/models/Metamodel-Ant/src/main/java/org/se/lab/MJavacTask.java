package org.se.lab;

public class MJavacTask
	extends MTask
{

	/*
	 * Property: srcdir
	 */
	private String srcdir;
	public String getSrcdir()
	{
		return srcdir;
	}
	public void setSrcdir(String srcdir)
	{
		this.srcdir = srcdir;
	}
	
	
	/*
	 * Property: destdir
	 */
	private String destdir;
	public String getDestdir()
	{
		return destdir;
	}
	public void setDestdir(String destdir)
	{
		this.destdir = destdir;
	}
	
}
