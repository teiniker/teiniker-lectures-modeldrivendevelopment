package org.se.lab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AntGeneratorTest
{
	protected MProject ant;
		
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
	
	@Test
	public void testGenerate()
	{
		AntGenerator generator = new AntGenerator();
		String xml = generator.generate(ant);
		String expected = readFile("simple-ant.xml");
		Assert.assertEquals(expected, xml);
	}
	
	
	protected String readFile(String filename)
	{
		try (BufferedReader br = new BufferedReader(new FileReader(new File(
				"src/test/resources", filename))))
		{
			StringBuilder xml = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null)
			{
				xml.append(line).append('\n');
			}
			return xml.toString();
		}
		catch(IOException e)
		{
			throw new IllegalStateException(e);
		}
	}
}
