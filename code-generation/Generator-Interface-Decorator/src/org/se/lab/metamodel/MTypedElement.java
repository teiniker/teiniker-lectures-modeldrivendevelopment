package org.se.lab.metamodel;

public abstract class MTypedElement
	extends MNamedElement
{
	/*
	 * Constructor
	 */
	public MTypedElement(String name, MType type)
	{
		super(name);
		setType(type);
	}
	
	
	/*
	 * Reference: ---[1]-> type:MType
	 */
	private MType type;
	public MType getType()
	{
		return type;
	}
	public void setType(MType type)
	{
		this.type = type;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		MTypedElement other = (MTypedElement) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}	
}
