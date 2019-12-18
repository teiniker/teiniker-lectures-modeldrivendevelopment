package org.se.lab;

public class MWebPage
{
	/*
	 * Reference: ---[1]-> MHead
	 */
	private MHead head;
	public MHead getHead()
	{
		return head;
	}
	public void setHead(MHead head)
	{
		this.head = head;
	}
	

	/*
	 * Reference: ---[1]-> MBody
	 */
	private MBody body;
	public MBody getBody()
	{
		return body;
	}
	public void setBody(MBody body)
	{
		this.body = body;
	}
	
}
