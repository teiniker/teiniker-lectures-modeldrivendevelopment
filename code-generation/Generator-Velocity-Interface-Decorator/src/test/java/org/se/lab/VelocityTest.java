package org.se.lab;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.metamodel.MPackage;

public class VelocityTest
{
	private MPackage pkg;
	private VelocityContext context;
	private static final String OUTPUT_FOLDER = "src/generated/java/org/se/lab/";
	private static final String TEMPLATE_FOLDER = "src/main/resources/templates/";
	
	@Before
	public void setup()
	{
		pkg = new PackageBuilder("org.se.lab")
		.iface("Stack").isPublic()
			.operation("push").asVoid().parameter("value").asInt()
			.operation("pop").asInt()
			.operation("top").asInt()
			.operation("isEmpty").asBoolean()
			.operation("isFull").asBoolean()			
		.toPackage();
		
		Velocity.init();
	    context = new VelocityContext();
        
        context.put("package", pkg);
        
        // TODO: Mehrere Interfaces möglich - hier oder im Template über die Liste iterieren
        context.put("iface", pkg.getInterfaces().get(0));
	}

	
	@Test
	public void testInterfaceVelocity()
	{
        Template template = Velocity.getTemplate(TEMPLATE_FOLDER + "InterfaceTemplate.vm");
        StringWriter sw = new StringWriter();
        template.merge(context, sw);
        
        // Write to file
        writeToFile("Stack.java", sw.toString());
	}

	
	@Test
	public void testAbstractDecoratorVelocity()
	{
		context.put("ifaceNameLower", pkg.getInterfaces().get(0).getName().substring(0, 1).toLowerCase() + 
			pkg.getInterfaces().get(0).getName().substring(1));
		
		Template template = Velocity.getTemplate(TEMPLATE_FOLDER + "AbstractDecoratorTemplate.vm");
        StringWriter sw = new StringWriter();
        template.merge(context, sw);

        // Write to file
        writeToFile("AbstractStackDecorator.java", sw.toString());
	}

	
	@Test
	public void testMonitorDecoratorGenerator()
	{
		context.put("ifaceNameLower", pkg.getInterfaces().get(0).getName().substring(0, 1).toLowerCase() + 
				pkg.getInterfaces().get(0).getName().substring(1));
		
		Template template = Velocity.getTemplate(TEMPLATE_FOLDER + "MonitorDecoratorTemplate.vm");
        StringWriter sw = new StringWriter();
        template.merge(context, sw);
        
        // Write to file
        writeToFile("StackMonitorDecorator.java", sw.toString());
	}

	
	public void writeToFile(String filename, String code)
	{
		File file = new File(OUTPUT_FOLDER, filename);
		
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) 
		{
			bw.write(code);
		}
		catch (IOException e)
		{
			throw new IllegalStateException(e);
		}
	}	
}
