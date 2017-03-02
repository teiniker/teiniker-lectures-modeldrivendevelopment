package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.metamodel.MEntity;
import org.se.lab.metamodel.MInteger;
import org.se.lab.metamodel.MProperty;
import org.se.lab.metamodel.MString;

public class EntityMapperTest
{
	private MEntity entity;
	
	@Before
	public void setup()
	{
		EntityMapper mapper = new EntityMapper();		
		entity = mapper.toMEntity(User.class);
	}

	
	@Test
    public void testId()
    {
        MProperty id = entity.getProperties().get(0);
        Assert.assertEquals("id", id.getName());
        Assert.assertTrue(id.getType() instanceof MInteger);
        Assert.assertTrue(id.isId());
    }
    
    @Test
    public void testPropertyUsername()
    {
        MProperty p = entity.getProperties().get(1);
        Assert.assertEquals("username", p.getName());
        Assert.assertTrue(p.getType() instanceof MString);
    }
    
    @Test
    public void testPropertyPassword()
    {
        MProperty p = entity.getProperties().get(2);
        Assert.assertEquals("password", p.getName());
        Assert.assertTrue(p.getType() instanceof MString);
    }    
	
}
