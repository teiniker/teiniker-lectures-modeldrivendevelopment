package org.se.lab.expressionbuilder;

import java.util.ArrayList;
import java.util.List;

import org.se.lab.metamodel.MPackage;

public class PackageBuilder {
	
	private String name;
	
	private List<InterfaceBuilder> interfaceBuilders = new ArrayList<>();
	
	public PackageBuilder(String name) {
		this.name = name;
	}
	
	public InterfaceBuilder interfac(String name) {
		InterfaceBuilder interfaceBuilder = new InterfaceBuilder(this, name);
		this.interfaceBuilders.add(interfaceBuilder);
		return interfaceBuilder;
	}
	
	public MPackage toPackage() {
		MPackage mPackage = new MPackage(this.name);
		
		for (InterfaceBuilder interfaceBuilder : this.interfaceBuilders) {
			mPackage.getInterfaces().add(interfaceBuilder.toInterface());
		}
		
		return mPackage;
	}
}
