package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.metamodel.EntityValidator;
import org.se.lab.metamodel.MEntity;
import org.se.lab.metamodel.MInteger;
import org.se.lab.metamodel.MProperty;
import org.se.lab.metamodel.MString;


public class EntityValidatorTest
{
    private MEntity entity;
    private EntityValidator validator;
    
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
        
        validator = new EntityValidator();
    }
    
    
    @Test
    public void testEntityValidator()
    {
        validator.visit(entity);
    }
    

    @Test
    public void testValidModel()
    {
    	validator.visit(entity);
    }

    
    @Test
    public void testTwoIds()
    {
    	entity.getProperties().get(1).setId(true);
    	
    	try
    	{
			validator.visit(entity);
			Assert.fail();
    	}
    	catch(IllegalStateException e)
    	{
    		Assert.assertEquals("MProperty.id is set more than once", e.getMessage());
    	}
    }
    
    
    @Test
    public void testEntity_WrongName()
    {
    	entity.setName("int");
    	
    	try
    	{
			validator.visit(entity);
			Assert.fail();
    	}
    	catch(IllegalStateException e)
    	{
    		Assert.assertEquals("Entity.name is a keyword: int", e.getMessage());
    	}    	   	
    }

    
    @Test
    public void testProperty_WrongName()
    {
    	entity.getProperties().get(2).setName("final");
    	
    	try
    	{
			validator.visit(entity);
			Assert.fail();
    	}
    	catch(IllegalStateException e)
    	{
    		Assert.assertEquals("MProperty.name is a keyword: final", e.getMessage());
    	}    	   	
    }

}
