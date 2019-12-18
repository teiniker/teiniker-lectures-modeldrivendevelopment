package org.se.lab;

import org.junit.Before;

public class ExpressionBuilderTest 
	extends AbstractTest
{
	@Before
	public void setup()
	{
		pom = new PomBuilder()
			.groupId("org.se.lab").artifactId("Metamodel-POM").version("0.0.1-SNAPSHOT").packaging("jar")
				.dependency().groupId("junit").artifactId("junit").version("4.11")
				.dependency().groupId("org.apache.velocity").artifactId("velocity").version("1.7")
			.toPom();
	}

}
