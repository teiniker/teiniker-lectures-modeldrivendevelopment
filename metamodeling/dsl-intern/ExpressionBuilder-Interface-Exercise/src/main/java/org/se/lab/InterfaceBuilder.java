package org.se.lab;

import java.util.ArrayList;
import java.util.List;

import org.se.lab.metamodel.MInterface;
import org.se.lab.metamodel.MPackage;

public class InterfaceBuilder
{
	private String name;
	private boolean pub = false;
	private PackageBuilder packageBuilder;

	private List<OperationBuilder> operationBuilders = new ArrayList<>();

	public InterfaceBuilder(PackageBuilder packageBuilder, String name)
	{
		this.packageBuilder = packageBuilder;
		this.name = name;
	}

	public InterfaceBuilder iface(String name)
	{
		return this.packageBuilder.iface(name);
	}

	public InterfaceBuilder isPublic()
	{
		this.pub = true;
		return this;
	}

	public OperationBuilder operation(String name)
	{
		OperationBuilder operationBuilder = new OperationBuilder(this, name);
		this.operationBuilders.add(operationBuilder);
		return operationBuilder;
	}

	public MInterface toInterface()
	{
		MInterface mInterface = new MInterface(this.name);
		mInterface.setPublic(this.pub);

		for (OperationBuilder operationBuilder : this.operationBuilders)
		{
			mInterface.getOperations().add(operationBuilder.toOperation());
		}

		return mInterface;
	}

	public MPackage toPackage()
	{
		return this.packageBuilder.toPackage();
	}
}
