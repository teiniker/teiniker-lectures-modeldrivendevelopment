package org.se.lab;

import org.junit.Before;

public class MetamodelTest
	extends AbstractTest
{
	@Before
	public void setup()
	{		
		// Project values 
		ant = new MProject();
		ant.setName("SimpleProject");
		ant.setBaseDir(".");
		
		// Description
		MDescription description = new MDescription();
		description.setText("Simple project build file");
		ant.setDescription(description);

		// Properties
		MProperty src = new MProperty();
		src.setName("src");
		src.setValue("./src");
		ant.getProperties().add(src);
		
		MProperty build = new MProperty();
		build.setName("build");
		build.setValue("./build");
		ant.getProperties().add(build);
		
		MProperty dist = new MProperty();
		dist.setName("dist");
		dist.setValue("./dist");
		ant.getProperties().add(dist);		
	}
}
