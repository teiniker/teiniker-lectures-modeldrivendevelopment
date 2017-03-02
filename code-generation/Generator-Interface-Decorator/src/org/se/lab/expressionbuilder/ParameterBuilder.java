package org.se.lab.expressionbuilder;

import org.se.lab.metamodel.MInterface;
import org.se.lab.metamodel.MOperation;
import org.se.lab.metamodel.MPackage;
import org.se.lab.metamodel.MParameter;

public class ParameterBuilder extends AbstractTypeBuilder<ParameterBuilder> {

	private String name;
	
	private OperationBuilder operationBuilder;
	
	public ParameterBuilder(OperationBuilder operationBuilder, String name) {
		this.name = name;
		this.operationBuilder = operationBuilder;
	}
	
	public InterfaceBuilder interfac(String name) {
		return this.operationBuilder.interfac(name);
	}

	public OperationBuilder operation(String name) {
		return this.operationBuilder.operation(name);
	}

	public ParameterBuilder parameter(String name) {
		return this.operationBuilder.parameter(name);
	}
	
	public MParameter toParameter() {
		return new MParameter(this.name, getType());
	}

	public MOperation toOperation() {
		return this.operationBuilder.toOperation();
	}
	
	public MInterface toInterface() {
		return this.operationBuilder.toInterface();
	}

	public MPackage toPackage() {
		return this.operationBuilder.toPackage();
	}
}