package org.se.lab;

public class TableValidator 
	implements MTableVisitor
{
	private boolean hasPrimaryKey = false;
	
	@Override
	public void visit(MTable t)
	{
		for(MColumn c : t.getColumns())
		{
			visit(c);
		}
	}

	@Override
	public void visit(MColumn c)
	{
		visit(c.getType());
		for(MConstraint constraint : c.getConstraints())
		{
			visit(constraint);
		}
	}

	@Override
	public void visit(MType t)
	{
		// do nothing
	}

	@Override
	public void visit(MConstraint c)
	{
		if(c.getName().equalsIgnoreCase("PRIMARY KEY"))			
		{
			if(hasPrimaryKey)
				throw new IllegalStateException("There are more than one primary keys in this table!");
			else
				hasPrimaryKey = true;
		}
	}
}
