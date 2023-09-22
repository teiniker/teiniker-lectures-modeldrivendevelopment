package org.se.lab.metamodel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GeneratorTest
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
    public void testProtoGenerator()
    {
        ProtoGenerator generator = new ProtoGenerator();
        generator.visit(proto);
        String code = generator.getCode();

        String expected = readFile("person.proto");
        Assert.assertEquals(expected, code);
    }

    protected String readFile(String filename)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(new File("src/test/resources", filename))))
        {
            StringBuilder code = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null)
            {
                code.append(line).append('\n');
            }
            return code.toString();
        }
        catch(IOException e)
        {
            throw new IllegalStateException(e);
        }
    }
}
