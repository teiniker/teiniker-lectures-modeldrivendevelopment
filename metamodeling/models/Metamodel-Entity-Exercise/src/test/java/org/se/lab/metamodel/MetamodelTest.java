package org.se.lab.metamodel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 * User: 
 * 	id:int [ID]
 * 	username:String
 * 	password: String
 */

public class MetamodelTest
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
    public void testMEntity()
    {
        Assert.assertEquals("User", entity.getName());
    }
    
    @Test
    public void testPropertyIsId()
    {
        MProperty p = entity.getProperties().get(0);
        Assert.assertEquals("id", p.getName());
        Assert.assertEquals(true, p.isId());
        Assert.assertTrue(p.getType() instanceof MInteger);
    }
    
    @Test
    public void testPropertyUsername()
    {
        MProperty p = entity.getProperties().get(1);
        Assert.assertEquals("username", p.getName());
        Assert.assertEquals(false, p.isId());
        Assert.assertTrue(p.getType() instanceof MString);
    }
    
    @Test
    public void testPropertyPassword()
    {
        MProperty p = entity.getProperties().get(2);
        Assert.assertEquals("password", p.getName());
        Assert.assertEquals(false, p.isId());
        Assert.assertTrue(p.getType() instanceof MString);
    }    
}
