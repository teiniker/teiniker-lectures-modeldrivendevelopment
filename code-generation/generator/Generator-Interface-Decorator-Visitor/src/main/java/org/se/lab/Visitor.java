package org.se.lab;

import org.se.lab.metamodel.MInterface;
import org.se.lab.metamodel.MNamedElement;
import org.se.lab.metamodel.MOperation;
import org.se.lab.metamodel.MPackage;
import org.se.lab.metamodel.MParameter;
import org.se.lab.metamodel.MType;
import org.se.lab.metamodel.MTypedElement;

public interface Visitor
{
	void visit(MInterface iface);
	void visit(MNamedElement namedElement);
	void visit(MOperation operation);
	void visit(MPackage pkg);
	void visit(MParameter parameter);
	void visit(MType type);
	void visit(MTypedElement typedElement);
	String toString();

}
