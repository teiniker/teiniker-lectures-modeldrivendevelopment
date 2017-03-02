package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractTest
{
	protected MProject ant;

	@Test
	public void testProject()
	{
		Assert.assertEquals("SimpleProject", ant.getName());
		Assert.assertEquals(".", ant.getBaseDir());
		Assert.assertEquals("Simple project build file", ant.getDescription().getText());
	}

	
	@Test
	public void testPropertySrc()
	{
		Assert.assertEquals("src", ant.getProperties().get(0).getName());
		Assert.assertEquals("./src", ant.getProperties().get(0).getValue());
	}

	@Test
	public void testPropertyBuild()
	{
		Assert.assertEquals("build", ant.getProperties().get(1).getName());
		Assert.assertEquals("./build", ant.getProperties().get(1).getValue());
	}
	
	@Test
	public void testPropertyDist()
	{
		Assert.assertEquals("dist", ant.getProperties().get(2).getName());
		Assert.assertEquals("./dist", ant.getProperties().get(2).getValue());
	}
}