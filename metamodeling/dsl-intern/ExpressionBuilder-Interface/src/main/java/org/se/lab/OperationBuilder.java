package org.se.lab;

import java.util.ArrayList;
import java.util.List;

import org.se.lab.metamodel.MInterface;
import org.se.lab.metamodel.MOperation;
import org.se.lab.metamodel.MPackage;
import org.se.lab.metamodel.MType;

public class OperationBuilder 
{
	private String name;
	private MType type;
	private InterfaceBuilder interfaceBuilder;
	private List<ParameterBuilder> parameterBuilders = new ArrayList<>();

	public OperationBuilder(InterfaceBuilder interfaceBuilder, String name)
	{
		this.name = name;
		this.interfaceBuilder = interfaceBuilder;
	}

	public InterfaceBuilder iface(String name)
	{
		return this.interfaceBuilder.iface(name);
	}

	public OperationBuilder operation(String name)
	{
		return this.interfaceBuilder.operation(name);
	}

	public OperationBuilder asVoid()
	{
		type = new MType("void");
		return this;
	}

	public OperationBuilder asInt()
	{
		type = new MType("int");
		return this;
	}

	public OperationBuilder asBoolean()
	{
		type = new MType("boolean");
		return this;
	}
	
	public ParameterBuilder parameter(String name)
	{
		ParameterBuilder parameterBuilder = new ParameterBuilder(this, name);
		this.parameterBuilders.add(parameterBuilder);
		return parameterBuilder;
	}

	public MOperation toOperation()
	{
		MOperation mOperation = new MOperation(this.name, type);

		for (ParameterBuilder parameterBuilder : this.parameterBuilders)
		{
			mOperation.getParameters().add(parameterBuilder.toParameter());
		}

		return mOperation;
	}

	public MInterface toInterface()
	{
		return this.interfaceBuilder.toInterface();
	}

	public MPackage toPackage()
	{
		return this.interfaceBuilder.toPackage();
	}
}
