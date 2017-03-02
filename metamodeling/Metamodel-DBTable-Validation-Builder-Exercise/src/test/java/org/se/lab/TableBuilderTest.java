package org.se.lab;

import org.junit.Before;

public class TableBuilderTest
	extends AbstractMetamodelTest
{
	@Before
	public void setup()
	{
		table = new TableBuilder()
			.name("User")
				   .column("id").type("INT").constraints("NOT NULL","PRIMARY KEY")
				   .column("username").type("VARCHAR(256)").constraints("NOT NULL")
				   .column("passwd").type("VARCHAR(256)").constraints("NOT NULL")
			.toTable();
	}
}
