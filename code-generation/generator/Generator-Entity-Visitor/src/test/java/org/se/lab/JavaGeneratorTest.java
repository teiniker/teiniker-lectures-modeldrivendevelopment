package org.se.lab;

import org.junit.Before;
import org.junit.Test;
import org.se.lab.metamodel.MEntity;
import org.se.lab.metamodel.MInteger;
import org.se.lab.metamodel.MProperty;
import org.se.lab.metamodel.MString;

public class JavaGeneratorTest
{
	private MEntity entity;
	
	@Before
	public void setup()
	{
		entity = new MEntity("User");
		MProperty p1 = new MProperty("id", new MInteger());
		p1.setId(true);		
		MString s = new MString();		
		MProperty p2 = new MProperty("username", s);
		MProperty p3 = new MProperty("password", s);
		MProperty p4 = new MProperty("email", new MString());
		entity.getProperties().add(p1);
		entity.getProperties().add(p2);
		entity.getProperties().add(p3);
		entity.getProperties().add(p4);
	}
	
	
	@Test
	public void testUserBean()
	{
		JavaBeanGenerator generator = new JavaBeanGenerator();
		System.out.println(generator.toJava(entity));
	}
}
