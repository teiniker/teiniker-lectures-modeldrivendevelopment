package org.se.lab.metamodel;

public interface ProtoVisitor
{
    void visit(MPackage pkg);
    void visit(MMessage msg);
    void visit(MField field);
    void visit(MType type);
}
