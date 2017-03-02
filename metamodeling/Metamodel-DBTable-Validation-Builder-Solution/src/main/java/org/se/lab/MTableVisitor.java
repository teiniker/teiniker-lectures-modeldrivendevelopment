package org.se.lab;

public interface MTableVisitor
{

	void visit(MTable t);

	void visit(MColumn c);

	void visit(MType t);

	void visit(MConstraint c);

}