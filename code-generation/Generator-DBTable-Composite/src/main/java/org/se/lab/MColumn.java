package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class MColumn extends MNamedElement
{
	/*
	 * Constructor
	 */
	public MColumn(String name)
	{
		super(name);
	}

	
	/*
	 * Reference: ---[1]-> MType
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
	
	
	/*
	 * Reference: ---[*]-> MConstraint
	 */
	private List<MConstraint> constraints = new ArrayList<MConstraint>();
	public List<MConstraint> getConstraints()
	{
		return constraints;
	}
	public void setConstraints(List<MConstraint> constraints)
	{
		this.constraints = constraints;
	}


	@Override
	public String toSql()
	{
		StringBuilder b = new StringBuilder();
		
		b.append(getName()).append(" ");
		b.append(getType().toSql()).append(" ");
		for(MConstraint c : getConstraints())
		{
			b.append(c.toSql()).append(" ");
		}
		return b.toString();
	}
}
