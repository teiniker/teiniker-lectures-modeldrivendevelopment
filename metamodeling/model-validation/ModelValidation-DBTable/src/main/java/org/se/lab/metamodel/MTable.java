package org.se.lab.metamodel;

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

	// Model Validation
	public void validate()
	{
		// validate

		// navigate
		getColumns().forEach(c -> c.validate());
	}
}
