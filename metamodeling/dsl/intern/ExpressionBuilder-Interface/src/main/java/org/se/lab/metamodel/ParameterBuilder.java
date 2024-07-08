package org.se.lab.metamodel;

public class ParameterBuilder
{
	private String name;
	private OperationBuilder operationBuilder;
	private MType type;
	
	public ParameterBuilder(OperationBuilder operationBuilder, String name)
	{
		this.name = name;
		this.operationBuilder = operationBuilder;
	}

	public InterfaceBuilder iface(String name)
	{
		return this.operationBuilder.iface(name);
	}

	public OperationBuilder operation(String name)
	{
		return this.operationBuilder.operation(name);
	}

	public ParameterBuilder parameter(String name)
	{
		return this.operationBuilder.parameter(name);
	}

	public ParameterBuilder asVoid()
	{
		type = new MType("void");
		return this;
	}

	public ParameterBuilder asInt()
	{
		type = new MType("int");
		return this;
	}

	public ParameterBuilder asBoolean()
	{
		type = new MType("boolean");
		return this;
	}

	public MParameter toParameter()
	{
		return new MParameter(this.name, type);
	}

	public MOperation toOperation()
	{
		return this.operationBuilder.toOperation();
	}

	public MInterface toInterface()
	{
		return this.operationBuilder.toInterface();
	}

	public MPackage toPackage()
	{
		return this.operationBuilder.toPackage();
	}
}