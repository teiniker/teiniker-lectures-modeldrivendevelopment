package org.se.lab;

import org.junit.Before;
import org.junit.Test;
import org.se.lab.metamodel.MPackage;

public class PackageBuilderTest
{
	private MPackage pkg;

	@Before
	public void setup()
	{
		pkg = new PackageBuilder("org.se.lab")
		.iface("Stack").isPublic()
			.operation("push").asVoid().parameter("value").asInt()
			.operation("pop").asInt()
			.operation("top").asInt().operation("isEmpty").asBoolean()
			.operation("isFull").asBoolean()
		.toPackage();
	}

	@Test
	public void testInterfaceGenerator()
	{
		Visitor generator = new GenInterfaceVisitorImpl();
		generator.visit(pkg);
		String code = generator.toString();
		System.out.println(code);
	}


	@Test
	public void testAbstractDecoratorGenerator()
	{
		Visitor generator = new GenAbstractDecoratorVisitorImpl();
		generator.visit(pkg);
		String code = generator.toString();
		System.out.println(code);
	}

	
	@Test
	public void testMonitorDecoratorGenerator()
	{
		Visitor generator = new GenMonitorDecoratorVisitorImpl();
		generator.visit(pkg);
		String code = generator.toString();
		System.out.println(code);
	}	
}
