package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.metamodel.MEntity;
import org.se.lab.metamodel.MInteger;
import org.se.lab.metamodel.MProperty;
import org.se.lab.metamodel.MString;

public class CreateTableGeneratorTest
{
	private Visitor visitor;
	
	
	@Before
	public void setup()
	{
	    visitor = new CreateTableGenerator();
	}
	
	
	@Test
	public void testVisitMInteger()
	{
	    MInteger integer = new MInteger();
	    Assert.assertEquals("INT", visitor.visitMInteger(integer));
	}
	
	
    @Test
    public void testVisitMString()
    {
        MString string = new MString();
        Assert.assertEquals("VARCHAR(256)", visitor.visitMString(string));
    }
	
    
    @Test
    public void testVisitMType()
    {
        MInteger integer = new MInteger();
        MString string = new MString();
        Assert.assertEquals("INT", visitor.visitMType(integer));
        Assert.assertEquals("VARCHAR(256)", visitor.visitMType(string));
    }
	
    
    @Test
    public void testVisitMProperty()
    {
        MProperty property = new MProperty("id", new MInteger());
        property.setId(true);
        Assert.assertEquals("id INT PRIMARY KEY", visitor.visitMProperty(property));
    }
    
    	
	@Test
	public void testVisitMEntity()
	{
	    MEntity entity = new MEntity("User");
	    MProperty id = new MProperty("id", new MInteger());
	    id.setId(true);
	    entity.getProperties().add(id);
	    entity.getProperties().add(new MProperty("username", new MString()));
	    entity.getProperties().add(new MProperty("password", new MString()));

	    final String STRUCT = 
	        "CREATE TABLE User (\n" +
	        "    id INT PRIMARY KEY,\n" +
	        "    username VARCHAR(256),\n" +
	        "    password VARCHAR(256)\n" +
	        ");";
		
	    String code = visitor.visitMEntity(entity);
	    System.out.println(code);
		Assert.assertEquals(STRUCT, code);
	}
}
