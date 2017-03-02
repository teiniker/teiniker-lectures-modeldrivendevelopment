package org.se.lab;

public class MEdge
{
	/*
	 * Reference: --[1]-> from:MNode
	 */
	private MNode from;
	public MNode getFrom()
	{
		return from;
	}
	public void setFrom(MNode from)
	{
		this.from = from;
	}

	
	/*
	 * Reference: --[1]-> to:MNode
	 */
	private MNode to;
	public MNode getTo()
	{
		return to;
	}
	public void setTo(MNode to)
	{
		this.to = to;
	}
}
