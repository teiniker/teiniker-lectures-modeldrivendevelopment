package org.se.lab;

import org.se.lab.metamodel.MInterface;
import org.se.lab.metamodel.MOperation;
import org.se.lab.metamodel.MPackage;
import org.se.lab.metamodel.MParameter;
import org.se.lab.metamodel.MType;

public abstract class AbstractValidator
	implements InterfaceVisitor
{
	@Override
	public void visit(MPackage pkg)
	{
		// Validation
		
		// Naviagtion
		for(MInterface iface : pkg.getInterfaces())
		{
			visit(iface);
		}
	}

	@Override
	public void visit(MInterface iface)
	{
		// Validation
		
		// Naviagtion
		for(MOperation op : iface.getOperations())
		{
			visit(op);
		}
	}

	@Override
	public void visit(MOperation op)
	{
		// Validation
		
		// Naviagtion
		visit(op.getType());
		for(MParameter par : op.getParameters())
		{
			visit(par);
		}
	}

	@Override
	public void visit(MParameter par)
	{
		// Validation
		
		// Naviagtion
		visit(par.getType());
	}

	@Override
	public void visit(MType type)
	{
		// Validation
	}
}
