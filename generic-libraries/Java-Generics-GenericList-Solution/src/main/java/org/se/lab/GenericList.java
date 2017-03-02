package org.se.lab;

public interface GenericList<E extends Number>
{

	public abstract int size();

	public abstract double sum();

	public abstract GenericList<E> add(E value);

	public abstract E get(int index);

}