package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class MGraph
	extends MNamedElement
{
	/*
	 * Reference: ---[*]-> MNode
	 */
	List<MNode> nodes = new ArrayList<>();
	public List<MNode> getNodes()
	{
		return nodes;
	}
	public void setNodes(List<MNode> nodes)
	{
		this.nodes = nodes;
	}


	/*
	 * Reference: ---[*]-> MEdge
	 */
	List<MEdge> edges = new ArrayList<>();
	public List<MEdge> getEdges()
	{
		return edges;
	}
	public void setEdges(List<MEdge> edges)
	{
		this.edges = edges;
	}
}
