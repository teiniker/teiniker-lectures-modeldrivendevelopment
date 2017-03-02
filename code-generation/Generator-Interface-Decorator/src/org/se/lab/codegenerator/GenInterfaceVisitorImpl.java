package org.se.lab.codegenerator;

import org.se.lab.metamodel.MInterface;
import org.se.lab.metamodel.MOperation;

public class GenInterfaceVisitorImpl extends AbstractVisitorImpl {

	@Override
	public void visit(MInterface mInterface) {
		getSB().append(mInterface.isPublic() ? "public " : "");
		getSB().append("interface ");
		getSB().append(mInterface.getName());
		getSB().append(" {");
		
		for (MOperation mOperation : mInterface.getOperations()) {
			visit(mOperation);
		}
		
		getSB().append("}");
	}

	@Override
	public void visit(MOperation mOperation) {
		getSB().append("\n\t");
		visitSimpleOperation(mOperation);
		getSB().append(";\n");
	}
}
