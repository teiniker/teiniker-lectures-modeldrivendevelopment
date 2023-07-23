package org.se.lab;

public class SqlGeneratorVisitor
{

	public String visit(MTable t)
	{
		StringBuilder b = new StringBuilder();
		b.append("CREATE TABLE ").append(t.getName()).append(" (");
		int size = t.getColumns().size();
		
		for(int i = 0; i< size; i++)
		{
			MColumn co = t.getColumns().get(i);
			b.append(visit(co));
			if(i < size-1)
				b.append(",");
		}
		
		b.append(");");
		return  b.toString();
	}
	
	public String visit(MColumn c)
	{
		StringBuilder b = new StringBuilder();
		
		b.append(c.getName()).append(" ");
		b.append(visit(c.getType())).append(" ");
		for(MConstraint constr : c.getConstraints())
		{
			b.append(visit(constr)).append(" ");
		}
		return b.toString();
	}
	
	public String visit(MType t)
	{
		return t.getName();
	}

	public String visit(MConstraint c)
	{
		return c.getName();
	}
}
