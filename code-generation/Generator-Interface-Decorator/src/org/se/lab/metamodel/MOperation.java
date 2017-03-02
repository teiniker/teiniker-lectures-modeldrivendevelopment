package org.se.lab.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MOperation
	extends MTypedElement
{
	/*
	 * Constructor
	 */
	public MOperation(String name, MType type)
	{
		super(name,type);
	}
	
	
	/*
	 * Reference: ---[*]-> parameters:MParameter[*]
	 */
	private List<MParameter> parameters = new ArrayList<MParameter>();
	public List<MParameter> getParameters()
	{
		return parameters;
	}
	public void setParameters(List<MParameter> parameters)
	{
		if(parameters == null)
			throw new IllegalArgumentException();
		this.parameters = parameters;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((parameters == null) ? 0 : parameters.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MOperation other = (MOperation) obj;
		if (parameters == null) {
			if (other.parameters != null)
				return false;
		} else if (!parameters.equals(other.parameters)) // right order!
			return false;
		return true;
	}
}
