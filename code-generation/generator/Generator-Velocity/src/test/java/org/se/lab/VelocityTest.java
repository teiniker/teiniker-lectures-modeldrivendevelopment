package org.se.lab;

import static org.junit.Assert.assertEquals;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;


public class VelocityTest
{
    @Test
    public void testVelocitySingleton() throws Exception
    {        
        Velocity.init();
        
        VelocityContext context = new VelocityContext();
        context.put("name", new String("Egon Teiniker"));
        
        Template template = Velocity.getTemplate("src/test/resources/templates/HelloTemplate.vm");
        StringWriter sw = new StringWriter();
        template.merge(context, sw);
        
        assertEquals("Hello Egon Teiniker!", sw.toString());
    }
    
    
    @Test
    public void testVelocityInstance() throws Exception
    {
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        
        VelocityContext context = new VelocityContext();
        context.put("name", new String("Egon Teiniker"));
        
        Template template = ve.getTemplate("src/test/resources/templates/HelloTemplate.vm");
        StringWriter sw = new StringWriter();
        template.merge(context, sw);
        
        assertEquals("Hello Egon Teiniker!", sw.toString());
    }

    
    @Test
    public void testCollectionTemplate() throws Exception
    {
        Velocity.init();

        VelocityContext context = new VelocityContext();
        List<String> list = Arrays.asList("eins", "zwei", "drei", "vier", "fünf");
        context.put("list", list);
                
        StringWriter sw = new StringWriter();
        Velocity.mergeTemplate("src/test/resources/templates/CollectionTemplate.vm","UTF-8", context, sw);

        System.out.println(sw.toString());     
    }
}
