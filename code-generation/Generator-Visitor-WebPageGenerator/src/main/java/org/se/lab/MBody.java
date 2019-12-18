package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class MBody
{

	/*
	 * Reference: ---[*]-> MPageElement
	 */
	private List<MPageElement> elements = new ArrayList<MPageElement>();
	public List<MPageElement> getElements()
	{
		return elements;
	}
	public void setElements(List<MPageElement> elements)
	{
		this.elements = elements;
	}
	
}
