package org.se.lab;

import org.se.lab.metamodel.MEntity;
import org.se.lab.metamodel.MInteger;
import org.se.lab.metamodel.MProperty;
import org.se.lab.metamodel.MString;
import org.se.lab.metamodel.MType;

public interface EntityVisitor
{
	void visit(MEntity entity);
	void visit(MProperty property);
	void visit(MType type);
	void visit(MInteger i);
	void visit(MString s);
}
