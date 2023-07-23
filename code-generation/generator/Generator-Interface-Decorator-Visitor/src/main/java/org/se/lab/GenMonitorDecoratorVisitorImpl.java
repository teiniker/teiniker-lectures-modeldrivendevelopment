package org.se.lab;

import org.se.lab.metamodel.MInterface;
import org.se.lab.metamodel.MOperation;
import org.se.lab.metamodel.MParameter;

public class GenMonitorDecoratorVisitorImpl 
	extends AbstractVisitorImpl
{

	@Override
	public void visit(MInterface mInterface)
	{
		// class declaration
		getSB().append("\npublic class ");
		getSB().append(mInterface.getName());
		getSB().append("MonitorDecorator extends Abstract");
		getSB().append(mInterface.getName());
		getSB().append("Decorator {\n");

		// constructor
		getSB().append("\n\tpublic ");
		getSB().append(mInterface.getName());
		getSB().append("MonitorDecorator(");
		getSB().append(mInterface.getName());
		getSB().append(" ");
		getSB().append(firstLetterToLowerCase(mInterface.getName()));
		getSB().append(") {\n");
		getSB().append("\t\tsuper(");
		getSB().append(firstLetterToLowerCase(mInterface.getName()));
		getSB().append(");\n");
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

		// localvars
		getSB().append("\t\tlong time, timediff;\n");
		if (!mOperation.getType().getName().equals("void"))
		{
			getSB().append("\t\t");
			visit(mOperation.getType());
			getSB().append(" ");
			getSB().append(firstLetterToLowerCase(mOperation.getName()));
			getSB().append(";\n");
		}

		getSB().append("\n");

		appendSystemOutLine("\"method: " + mOperation.getName() + "\"");
		for (MParameter mParameter : mOperation.getParameters())
		{
			visitPrintParameter(mParameter);
		}

		getSB().append("\n");

		getSB().append("\t\ttime = System.currentTimeMillis();\n");

		getSB().append("\t\t");
		if (!mOperation.getType().getName().equals("void"))
		{
			getSB().append(firstLetterToLowerCase(mOperation.getName()));
			getSB().append(" = ");
		}
		getSB().append("super.");
		visitSimpleOperation(mOperation, false);
		getSB().append(";\n");
		getSB().append("\t\ttimediff = System.currentTimeMillis() - time;\n");

		getSB().append("\n");

		appendSystemOutLine("\"time: \" + timediff + \"ms\"");

		if (!mOperation.getType().getName().equals("void"))
		{
			appendSystemOutLine("\"return: \" + "
					+ firstLetterToLowerCase(mOperation.getName()));

			getSB().append("\t\treturn ");
			getSB().append(firstLetterToLowerCase(mOperation.getName()));
			getSB().append(";\n");
		}

		getSB().append("\t}\n");
	}

	private void visitPrintParameter(MParameter mParameter)
	{
		appendSystemOutLine("\"parameter " + mParameter.getName() + ": \" + "
				+ mParameter.getName());
	}

	private void appendSystemOutLine(String line)
	{
		getSB().append("\t\tSystem.out.println(");
		getSB().append(line);
		getSB().append(");\n");
	}

	private static String firstLetterToLowerCase(String word)
	{
		return word.substring(0, 1).toLowerCase() + word.substring(1);
	}
}
