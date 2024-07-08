package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.metamodel.MColumn;
import org.se.lab.metamodel.MTable;
import org.se.lab.metamodel.TableBuilder;

public class TableBuilderTest
{
	@Before
	public void setup()
	{
		table = new TableBuilder().name("User")
				   		.column("id").type("INT").constraints("NOT NULL","PRIMARY KEY")
				   		.column("username").type("VARCHAR(256)").constraints("NOT NULL")
				   		.column("passwd").type("VARCHAR(256)").constraints("NOT NULL")
				   .toTable();
	}

	protected MTable table;

	@Test
	public void testTable()
	{
		Assert.assertEquals("User", table.getName());
		Assert.assertEquals(3, table.getColumns().size());
	}

	@Test
	public void testColumnId()
	{
		MColumn id = table.getColumns().get(0);

		Assert.assertEquals("id", id.getName());
		Assert.assertEquals("INT", id.getType().getName());
		Assert.assertEquals("NOT NULL", id.getConstraints().get(0).getName());
		Assert.assertEquals("PRIMARY KEY", id.getConstraints().get(1).getName());
	}

	@Test
	public void testUsername()
	{
		MColumn username = table.getColumns().get(1);

		Assert.assertEquals("username", username.getName());
		Assert.assertEquals("VARCHAR(256)", username.getType().getName());
		Assert.assertEquals("NOT NULL", username.getConstraints().get(0).getName());
	}

	@Test
	public void testPasswd()
	{
		MColumn passwd = table.getColumns().get(2);

		Assert.assertEquals("passwd", passwd.getName());
		Assert.assertEquals("VARCHAR(256)", passwd.getType().getName());
		Assert.assertEquals("NOT NULL", passwd.getConstraints().get(0).getName());
	}
}
