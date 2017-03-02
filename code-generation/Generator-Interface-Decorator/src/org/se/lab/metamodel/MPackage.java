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
		super(name);
	}
	
	
	/*
	 * Reference: ---[*]-> MInterface
	 */
	List<MInterface> interfaces = new ArrayList<MInterface>();
	public List<MInterface> getInterfaces()
	{
		return interfaces;
	}
	public void setInterfaces(List<MInterface> interfaces)
	{
		this.interfaces = interfaces;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((interfaces == null) ? 0 : interfaces.hashCode());
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
		MPackage other = (MPackage) obj;
		if (interfaces == null) {
			if (other.interfaces != null)
				return false;
		} else if (!interfaces.containsAll(other.interfaces) || !other.interfaces.containsAll(interfaces)) // any order
			return false;
		return true;
	}
}
