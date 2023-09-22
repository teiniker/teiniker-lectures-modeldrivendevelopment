package org.se.lab.metamodel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModelValidationTest
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
    public void testValidModel()
    {
        proto.validate();
    }

    @Test(expected = IllegalStateException.class)
    public void testInvalidPackageName_null()
    {
        proto.setName(null);
        proto.validate();
    }

    @Test(expected = IllegalStateException.class)
    public void testInvalidPackageName_Empty()
    {
        proto.setName("  ");
        proto.validate();
    }


    @Test(expected = IllegalStateException.class)
    public void testInvalidMessageName_null()
    {
        proto.getMessages().get(0).setName(null);
        proto.validate();
    }

    @Test(expected = IllegalStateException.class)
    public void testInvalidMessageName_Empty()
    {
        proto.getMessages().get(0).setName("   ");
        proto.validate();
    }


    @Test(expected = IllegalStateException.class)
    public void testInvalidFieldName_null()
    {
        proto.getMessages().get(0).getFields().get(0).setName(null);
        proto.validate();
    }

    @Test(expected = IllegalStateException.class)
    public void testInvalidFieldName_Empty()
    {
        proto.getMessages().get(0).getFields().get(0).setName("   ");
        proto.validate();
    }

    @Test(expected = IllegalStateException.class)
    public void testInvalidFieldNumber()
    {
        proto.getMessages().get(0).getFields().get(0).setNumber(0);
        proto.validate();
    }

    @Test(expected = IllegalStateException.class)
    public void testInvalidFieldType_null()
    {
        proto.getMessages().get(0).getFields().get(0).setType(null);
        proto.validate();
    }

    @Test(expected = IllegalStateException.class)
    public void testInvalidTypeName_null()
    {
        proto.getMessages().get(0).getFields().get(0).getType().setName(null);
        proto.validate();
    }

    @Test(expected = IllegalStateException.class)
    public void testInvalidTypeName_Empty()
    {
        proto.getMessages().get(0).getFields().get(0).getType().setName("   ");
        proto.validate();
    }

    @Test(expected = IllegalStateException.class)
    public void testInvalidTypeName_char()
    {
        proto.getMessages().get(0).getFields().get(0).getType().setName("char");
        proto.validate();
    }

    @Test(expected = IllegalStateException.class)
    public void testInvalidTypeName_int()
    {
        proto.getMessages().get(0).getFields().get(0).getType().setName("int");
        proto.validate();
    }
}
