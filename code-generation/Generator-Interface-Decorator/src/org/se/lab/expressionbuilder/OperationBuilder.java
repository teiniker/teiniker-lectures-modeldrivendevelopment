package org.se.lab.expressionbuilder;

import java.util.ArrayList;
import java.util.List;

import org.se.lab.metamodel.MInterface;
import org.se.lab.metamodel.MOperation;
import org.se.lab.metamodel.MPackage;

public class OperationBuilder extends AbstractTypeBuilder<OperationBuilder> {
	private String name;
	
	private InterfaceBuilder interfaceBuilder;
	
	private List<ParameterBuilder> parameterBuilders = new ArrayList<>();
	
	public OperationBuilder(InterfaceBuilder interfaceBuilder, String name) {
		this.name = name;
		this.interfaceBuilder = interfaceBuilder;
	}

	public InterfaceBuilder interfac(String name) {
		return this.interfaceBuilder.interfac(name);
	}

	public OperationBuilder operation(String name) {
		return this.interfaceBuilder.operation(name);
	}

	public ParameterBuilder parameter(String name) {
		ParameterBuilder parameterBuilder = new ParameterBuilder(this, name);
		this.parameterBuilders.add(parameterBuilder);
		return parameterBuilder;
	}

	public MOperation toOperation() {
		MOperation mOperation = new MOperation(this.name, getType());
		
		for (ParameterBuilder parameterBuilder : this.parameterBuilders) {
			mOperation.getParameters().add(parameterBuilder.toParameter());
		}
		
		return mOperation;
	}
	
	public MInterface toInterface() {
		return this.interfaceBuilder.toInterface();
	}
	

	public MPackage toPackage() {
		return this.interfaceBuilder.toPackage();
	}
}
