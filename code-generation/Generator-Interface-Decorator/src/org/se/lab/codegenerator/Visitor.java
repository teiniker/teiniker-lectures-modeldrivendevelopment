package org.se.lab.codegenerator;

import org.se.lab.metamodel.MInterface;
import org.se.lab.metamodel.MNamedElement;
import org.se.lab.metamodel.MOperation;
import org.se.lab.metamodel.MPackage;
import org.se.lab.metamodel.MParameter;
import org.se.lab.metamodel.MType;
import org.se.lab.metamodel.MTypedElement;

public interface Visitor {

	void visit(MInterface mInterface);
	
	void visit(MNamedElement mNamedElement);
	
	void visit(MOperation mOperation);
	
	void visit(MPackage mPackage);
	
	void visit(MParameter mParameter);
	
	void visit(MType mType);
	
	void visit(MTypedElement mTypedElement);
	
	String genCode();
	
}
