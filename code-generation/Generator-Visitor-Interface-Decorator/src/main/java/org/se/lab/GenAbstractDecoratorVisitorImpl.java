package org.se.lab;

import org.se.lab.metamodel.MInterface;
import org.se.lab.metamodel.MOperation;

public class GenAbstractDecoratorVisitorImpl extends AbstractVisitorImpl
{

	private String lastInterfaceName = null;

	@Override
	public void visit(MInterface mInterface)
	{
		// store interface name for memberproperty
		this.lastInterfaceName = mInterface.getName();

		// class declaration
		getSB().append("\npublic abstract class Abstract");
		getSB().append(mInterface.getName());
		getSB().append("Decorator implements ");
		getSB().append(mInterface.getName());
		getSB().append(" {\n");

		// member
		getSB().append("\tprivate ");
		getSB().append(mInterface.getName());
		getSB().append(" ");
		getSB().append(firstLetterToLowerCase(mInterface.getName()));
		getSB().append(";\n");

		// constructor
		getSB().append("\n\tpublic Abstract");
		getSB().append(mInterface.getName());
		getSB().append("Decorator(");
		getSB().append(mInterface.getName());
		getSB().append(" ");
		getSB().append(firstLetterToLowerCase(mInterface.getName()));
		getSB().append(") {\n");
		getSB().append("\t\tthis.");
		getSB().append(firstLetterToLowerCase(mInterface.getName()));
		getSB().append(" = ");
		getSB().append(firstLetterToLowerCase(mInterface.getName()));
		getSB().append(";\n");
		getSB().append("\t}\n");

		// methods
		for (MOperation mOperation : mInterface.getOperations())
		{
			visit(mOperation);
		}

		getSB().append("}");
	}

	@Override
	public void visit(MOperation mOperation)
	{
		getSB().append("\n\t@Override\n");
		getSB().append("\tpublic ");
		visitSimpleOperation(mOperation);
		getSB().append(" {\n");
		getSB().append("\t\t");
		if (!mOperation.getType().getName().equals("void"))
		{
			getSB().append("return ");
		}
		getSB().append("this.");
		getSB().append(firstLetterToLowerCase(this.lastInterfaceName));
		getSB().append(".");
		visitSimpleOperation(mOperation, false);
		getSB().append(";\n");
		getSB().append("\t}\n");
	}

	private static String firstLetterToLowerCase(String word)
	{
		return word.substring(0, 1).toLowerCase() + word.substring(1);
	}
}
