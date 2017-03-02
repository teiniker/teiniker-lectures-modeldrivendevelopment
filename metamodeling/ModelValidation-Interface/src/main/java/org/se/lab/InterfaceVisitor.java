package org.se.lab;

import org.se.lab.metamodel.MInterface;
import org.se.lab.metamodel.MOperation;
import org.se.lab.metamodel.MPackage;
import org.se.lab.metamodel.MParameter;
import org.se.lab.metamodel.MType;

public interface InterfaceVisitor
{
	void visit(MPackage pkg);
	void visit(MInterface iface);
	void visit(MOperation op);
	void visit(MParameter par);
	void visit(MType type);
}
