package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class MTable extends MNamedElement
{
	/*
	 * Constructor
	 */
	public MTable(String name)
	{
		super(name);
	}

	/*
	 * Reference: ---[*]-> MColumn
	 */
	private List<MColumn> columns = new ArrayList<MColumn>();
	public List<MColumn> getColumns()
	{
		return columns;
	}
	public void setColumns(List<MColumn> columns)
	{
		this.columns = columns;
	}
	
	
	@Override
	public String toSql()
	{
		StringBuilder b = new StringBuilder();
		b.append("CREATE TABLE ").append(getName()).append(" (");
		int size = getColumns().size();
		
		for(int i = 0; i< size; i++)
		{
			MColumn co = getColumns().get(i);
			b.append(co.toSql());
			if(i < size-1)
				b.append(",");
		}
		
		b.append(");");
		return  b.toString();
	}
}
