package org.se.lab.metamodel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MetamodelTest
{
    private MPackage proto;
    
    @Before
    public void setup()
    {
        proto = new MPackage("org.se.lab");

        MMessage person = new MMessage("Person");
        person.getFields().add(new MField("id", 1, new MType("int32")));
        person.getFields().add(new MField("name", 2, new MType("string")));
        person.getFields().add(new MField("password", 3, new MType("string")));
        proto.getMessages().add(person);
    }
    
    @Test
    public void testMPackage()
    {
        Assert.assertEquals("org.se.lab", proto.getName());
    }
    
    @Test
    public void testMMessage()
    {
        MMessage person = proto.getMessages().get(0);

        Assert.assertEquals("Person", person.getName());

        Assert.assertEquals("id", person.getFields().get(0).getName());
        Assert.assertEquals(1, person.getFields().get(0).getNumber());
        Assert.assertEquals("int32", person.getFields().get(0).getType().getName());

        Assert.assertEquals("name", person.getFields().get(1).getName());
        Assert.assertEquals(2, person.getFields().get(1).getNumber());
        Assert.assertEquals("string", person.getFields().get(1).getType().getName());

        Assert.assertEquals("password", person.getFields().get(2).getName());
        Assert.assertEquals(3, person.getFields().get(2).getNumber());
        Assert.assertEquals("string", person.getFields().get(2).getType().getName());
    }
}
