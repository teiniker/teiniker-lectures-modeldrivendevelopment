package org.se.lab.metamodel;

import java.util.ArrayList;
import java.util.List;

public class TableBuilder
{
	private List<ColumnBuilder> columns = new ArrayList<ColumnBuilder>();
	private String name;
	
	public TableBuilder name(String name)
	{
		this.name = name;
		return this;
	}
	
	public MTable toTable()
	{
		MTable table = new MTable(name);
		for(ColumnBuilder c : columns)
		{
			// table.getColumns().add(c.toColumn());
			MColumn col = c.toColumn();
			List<MColumn> list = table.getColumns();
			list.add(col);
		}
		return table;
	}
	
	public ColumnBuilder column(String name)
	{
		ColumnBuilder child = new ColumnBuilder(name);
		columns.add(child);		
		return child;
	}
	
	
	/*
	 * Nested column builder
	 */
	public class ColumnBuilder
	{
		private String name;
		private MType type;
		private List<MConstraint> constraints = new ArrayList<MConstraint>();
		
		
		public ColumnBuilder(String name)
		{
			this.name = name;	
		}
		
		private MColumn toColumn()
		{
			MColumn column = new MColumn(name);
			column.setType(type);
			column.setConstraints(constraints);
			return column;
		}
				
		public ColumnBuilder type(String name)
		{
			this.type = new MType(name);
			return ColumnBuilder.this;
		}
		
		public ColumnBuilder constraints(String... names)
		{
			for(String name : names)
			{
				constraints.add(new MConstraint(name));
			}
			return ColumnBuilder.this;
		}
		
		// create another column
		public ColumnBuilder column(String name)
		{
			return TableBuilder.this.column(name);
		}
		
		// create the whole table
		public MTable toTable()
		{
			return TableBuilder.this.toTable();
		}
	}	
}
