package org.se.lab;

import java.lang.reflect.Field;

public interface EntityVisitor
{

	public abstract String visitEntity(Class<?> clazz);

	public abstract String visitProberty(Field field);

	public abstract String visitType(Field field);

}