package org.se.lab;

import org.junit.Before;

public class ExpressionBuilderTest 
	extends AbstractTest
{
	@Before
	public void setup()
	{
		ant = new AntBuilder()
			.name("SimpleProject").baseDir(".")
				.description("Simple project build file")
				.property().name("src").value("./src")
				.property().name("build").value("./build")
				.property().name("dist").value("./dist")
			.toAnt();		
	}
}
