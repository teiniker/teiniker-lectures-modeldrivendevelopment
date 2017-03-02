package org.se.lab.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MInterface
	extends MType
{
	/*
	 * Constructor
	 */
	public MInterface(String name)
	{
		super(name);
	}
	
	
	/*
	 * Property: pub:boolean
	 */
	private boolean pub;
	public boolean isPublic()
	{
		return pub;
	}
	public void setPublic(boolean pub)
	{
		this.pub = pub;
	}
	
	
	/*
	 * Reference: ---[*]-> MOperation
	 */
	List<MOperation> operations = new ArrayList<MOperation>();
	public List<MOperation> getOperations()
	{
		return operations;
	}
	public void setOperations(List<MOperation> operations)
	{
		this.operations = operations;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((operations == null) ? 0 : operations.hashCode());
		result = prime * result + (pub ? 1231 : 1237);
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
		MInterface other = (MInterface) obj;
		if (operations == null) {
			if (other.operations != null)
				return false;
		} else if (!operations.containsAll(other.operations) || !other.operations.containsAll(operations)) // any order
			return false;
		if (pub != other.pub)
			return false;
		return true;
	}
}
