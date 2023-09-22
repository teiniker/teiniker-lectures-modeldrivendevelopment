package org.se.lab.metamodel;

public class ProtoGenerator
    implements ProtoVisitor
{
    private StringBuilder code = new StringBuilder();

    public String getCode()
    {
        return code.toString();
    }

    @Override
    public void visit(MPackage pkg)
    {
        // Generate
        code.append("syntax = \"proto3\";").append("\n");
        code.append("option java_multiple_files = true;").append("\n\n");
        code.append("package ").append(pkg.getName()).append(";\n\n");

        // Navigate
        pkg.getMessages().forEach(this::visit);
    }

    @Override
    public void visit(MMessage msg)
    {
        // Generate
        code.append("message ").append(msg.getName()).append("\n");
        code.append("{").append("\n");
        msg.getFields().forEach(this::visit);
        code.append("}").append("\n");
    }

    @Override
    public void visit(MField field)
    {
        code.append("    ");
        visit(field.getType());
        code.append(" ").append(field.getName()).append(" = ").append(field.getNumber());
        code.append(";\n");
    }

    @Override
    public void visit(MType type)
    {
        code.append(type.getName());
    }
}
