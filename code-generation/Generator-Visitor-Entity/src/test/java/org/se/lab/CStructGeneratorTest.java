package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.metamodel.MEntity;
import org.se.lab.metamodel.MInteger;
import org.se.lab.metamodel.MProperty;
import org.se.lab.metamodel.MString;

public class CStructGeneratorTest
{
	private CStructGenerator visitor;
	
	
	@Before
	public void setup()
	{
	    visitor = new CStructGenerator();
	}
	
	
	@Test
	public void testVisitMInteger()
	{
	    MInteger integer = new MInteger();
	    Assert.assertEquals("int", visitor.visitMInteger(integer));
	}
	
	
    @Test
    public void testVisitMString()
    {
        MString string = new MString();
        Assert.assertEquals("char*", visitor.visitMString(string));
    }
	
    
    @Test
    public void testVisitMType()
    {
        MInteger integer = new MInteger();
        MString string = new MString();
        Assert.assertEquals("int", visitor.visitMType(integer));
        Assert.assertEquals("char*", visitor.visitMType(string));
    }
	
    
    @Test
    public void testVisitMProperty()
    {
        MProperty property = new MProperty("id", new MInteger());
        Assert.assertEquals("int id;", visitor.visitMProperty(property));
    }
    
    	
	@Test
	public void testVisitMEntity()
	{
	    MEntity bean = new MEntity("User");
	    bean.getProperties().add(new MProperty("id", new MInteger()));
	    bean.getProperties().add(new MProperty("username", new MString()));
	    bean.getProperties().add(new MProperty("password", new MString()));

	    final String STRUCT = 
	        "typedef struct {\n" +
	        "    int id;\n" +
	        "    char* username;\n" +
	        "    char* password;\n" +
	        "} User;";
		
	    String code = visitor.visitMEntity(bean);
	    System.out.println(code);
		Assert.assertEquals(STRUCT, code);
	}
}
