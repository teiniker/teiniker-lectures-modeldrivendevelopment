package org.se.lab;

import org.junit.Before;

public class MetamodelTest
	extends AbstractTest
{
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
		d1.setVersion("4.11");
		pom.getDependencies().add(d1);

		MDependency d2 = new MDependency();
		d2.setGroupId("org.apache.velocity");
		d2.setArtifactId("velocity");
		d2.setVersion("1.7");
		pom.getDependencies().add(d2);
	}
}
