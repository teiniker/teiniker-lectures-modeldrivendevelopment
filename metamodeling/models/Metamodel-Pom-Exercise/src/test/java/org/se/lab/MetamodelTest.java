package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MetamodelTest
{
	protected MProjectObjectModel pom;

	@Before
	public void setup()
	{
		pom = new MProjectObjectModel();
		pom.setGroupId("org.se.lab");
		pom.setArtifactId("Metamodel-POM");
		pom.setVersion("0.0.1-SNAPSHOT");
		pom.setPackaging("jar");
		
		MDependency d1 = new MDependency();
		d1.setGroupId("junit");
		d1.setArtifactId("junit");
		d1.setVersion("4.12");
		pom.getDependencies().add(d1);

		MDependency d2 = new MDependency();
		d2.setGroupId("org.apache.velocity");
		d2.setArtifactId("velocity");
		d2.setVersion("1.7");
		pom.getDependencies().add(d2);
	}

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
		Assert.assertEquals("4.12", pom.getDependencies().get(0).getVersion());
	}

	@Test
	public void testDependencyVelocity()
	{
		Assert.assertEquals("org.apache.velocity", pom.getDependencies().get(1).getGroupId());
		Assert.assertEquals("velocity", pom.getDependencies().get(1).getArtifactId());
		Assert.assertEquals("1.7", pom.getDependencies().get(1).getVersion());
	}
}
