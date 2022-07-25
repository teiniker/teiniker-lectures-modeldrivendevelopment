package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.metamodel.MEntity;
import org.se.lab.metamodel.MInteger;
import org.se.lab.metamodel.MProperty;
import org.se.lab.metamodel.MString;


public class EntityValidatorTest
{
    private MEntity entity;

    @Before
    public void setup()
    {
        entity = new MEntity("User");
        MProperty id = new MProperty("id", new MInteger());
        id.setId(true);
        entity.getProperties().add(id);
        
        MString t = new MString();
        MProperty p = new MProperty("username", t);
        entity.getProperties().add(p);
        
        entity.getProperties().add(new MProperty("password", new MString()));
    }
    
    
    @Test
    public void testEntityValidator()
    {
        entity.validate();
    }

    @Test
    public void testEntity_WrongName()
    {
    	entity.setName("int");
    	
    	try
    	{
			entity.validate();
			Assert.fail();
    	}
    	catch(IllegalStateException e)
    	{
    		Assert.assertEquals("MEntity.name is a keyword: int", e.getMessage());
    	}    	   	
    }

    @Test
    public void testProperty_WrongName()
    {
    	entity.getProperties().get(2).setName("final");
    	
    	try
    	{
			entity.validate();
			Assert.fail();
    	}
    	catch(IllegalStateException e)
    	{
    		Assert.assertEquals("MProperty.name is a keyword: final", e.getMessage());
    	}    	   	
    }

    @Test
    public void testNoId()
    {
        entity.getProperties().get(0).setId(false);

        try
        {
            entity.validate();
            Assert.fail();
        }
        catch(IllegalStateException e)
        {
            Assert.assertEquals("MEntity has no id!", e.getMessage());
        }
    }

    @Test
    public void testTooManyId()
    {
        entity.getProperties().get(1).setId(true);

        try
        {
            entity.validate();
            Assert.fail();
        }
        catch(IllegalStateException e)
        {
            Assert.assertEquals("MEntity has more than one ids!", e.getMessage());
        }
    }
}
