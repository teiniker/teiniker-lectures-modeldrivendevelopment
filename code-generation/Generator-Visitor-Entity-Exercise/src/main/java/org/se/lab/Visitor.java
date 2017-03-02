package org.se.lab;

import org.se.lab.metamodel.MEntity;
import org.se.lab.metamodel.MInteger;
import org.se.lab.metamodel.MProperty;
import org.se.lab.metamodel.MString;
import org.se.lab.metamodel.MType;

public interface Visitor
{
	String visitMInteger(MInteger arg);
	String visitMString(MString arg);
	String visitMType(MType type);
	String visitMProperty(MProperty property);
	String visitMEntity(MEntity bean);
}