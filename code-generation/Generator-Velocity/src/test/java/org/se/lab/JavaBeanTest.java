package org.se.lab;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.MBean;
import org.se.lab.MInteger;
import org.se.lab.MProperty;
import org.se.lab.MString;

public class JavaBeanTest
{
	private static final String TEMPLATE_FILE = "templates/JavaBeanTemplate1.vm";
	private MBean bean;
	
	@Before
	public void setup()
	{
        bean = new MBean("User");
        
        MProperty id = new MProperty("id", new MInteger());
        id.setWritable(false);
        bean.addProperty(id);
        
        MProperty name = new MProperty("name", new MString());
//        name.setReadable(true);
        bean.addProperty(name);

        MProperty passwd = new MProperty("passwd", new MString());
        passwd.setReadable(true);
        bean.addProperty(passwd);		
	}
	
	
    @Test
    public void testVelocity() throws Exception
    {        
        Velocity.init();        
        VelocityContext context = new VelocityContext();
        context.put("helper", JavaGeneratorHelper.class);                
        context.put("bean", bean);
                
        Template template = Velocity.getTemplate(TEMPLATE_FILE);
        StringWriter sw = new StringWriter();        
        template.merge(context, sw);                
        
        System.out.println(sw.toString());        
    }
}