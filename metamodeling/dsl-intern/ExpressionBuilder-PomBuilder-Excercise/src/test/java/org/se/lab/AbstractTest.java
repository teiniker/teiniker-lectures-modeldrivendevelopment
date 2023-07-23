package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractTest
{
	protected MProjectObjectModel pom;

	@Test
	public void testModule()
	{
		Assert.assertEquals("org.se.lab", pom.getGroupId());
		Assert.assertEquals("Metamodel-POM", pom.getArtifactId());
		Assert.assertEquals("0.0.1-SNAPSHOT", pom.getVersion());
		Assert.assertEquals("jar", pom.getPackaging());
	}

	@Test
	public void testDependencyJUnit()
	{
		Assert.assertEquals("junit", pom.getDependencies().get(0).getGroupId());
		Assert.assertEquals("junit", pom.getDependencies().get(0).getArtifactId());
		Assert.assertEquals("4.11", pom.getDependencies().get(0).getVersion());
	}

	@Test
	public void testDependencyVelocity()
	{
		Assert.assertEquals("org.apache.velocity", pom.getDependencies().get(1).getGroupId());
		Assert.assertEquals("velocity", pom.getDependencies().get(1).getArtifactId());
		Assert.assertEquals("1.7", pom.getDependencies().get(1).getVersion());
	}
}