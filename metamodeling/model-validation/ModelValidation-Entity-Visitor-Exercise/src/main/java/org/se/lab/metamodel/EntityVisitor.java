package org.se.lab.metamodel;


public interface EntityVisitor
{
	void visit(MEntity entity);
	void visit(MProperty property);
	void visit(MType type);
	void visit(MString string);
	void visit(MInteger integer);
}
