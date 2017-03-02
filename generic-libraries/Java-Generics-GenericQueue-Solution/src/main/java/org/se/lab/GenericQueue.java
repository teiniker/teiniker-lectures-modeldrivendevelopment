package org.se.lab;

public interface GenericQueue<E>
{

	public abstract void enqueue(E value);

	public abstract E dequeue();

	public abstract boolean isEmpty();

	public abstract boolean isFull();

}