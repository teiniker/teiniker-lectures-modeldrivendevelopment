package org.se.lab;

import org.junit.Before;
import org.junit.Test;

public class GeneratorTest
{
	private MTable table;

	@Before
	public void setup()
	{
		table = new MTable("User");

		MColumn id = new MColumn("id");
		id.setType(new MType("INT"));
		id.getConstraints().add(new MConstraint("NOT NULL"));
		id.getConstraints().add(new MConstraint("PRIMARY KEY"));
		table.getColumns().add(id);

		MColumn username = new MColumn("username");
		username.setType(new MType("VARCHAR(256)"));
		username.getConstraints().add(new MConstraint("NOT NULL"));
		table.getColumns().add(username);

		MColumn passwd = new MColumn("passwd");
		passwd.setType(new MType("VARCHAR(256)"));
		passwd.getConstraints().add(new MConstraint("NOT NULL"));
		table.getColumns().add(passwd);
	}

	@Test
	public void testSqlGeneratorComposite()
	{
		String sql = table.toSql();

		System.out.println(sql);
	}
}
