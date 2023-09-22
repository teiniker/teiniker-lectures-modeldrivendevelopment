package org.se.lab.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MPackage
	extends MNamedElement
{
	/*
	 * Constructor
	 */
	public MPackage(String name)
	{
		setName(name);
	}
	
	
	/*
	 * Reference: ---[*]-> messages:MMessage[*]
	 */
	private List<MMessage> messages = new ArrayList<MMessage>();
	public List<MMessage> getMessages()
	{
		return messages;
	}
	public void setMessages(List<MMessage> messages)
	{
		this.messages = messages;
	}	

	/*
	 * Model Validation
	 */
	@Override
	public void validate()
	{
		// Validation
		if(getName() == null || getName().trim().length() == 0)
			throw new IllegalStateException("MPackage: Invalid name: " + getName());

		// Navigation
		getMessages().forEach(Validation::validate);
	}
}


