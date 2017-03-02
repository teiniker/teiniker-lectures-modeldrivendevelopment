package org.se.lab;

public interface Stack
{
	void push(int value);

	int pop();

	int top();

	boolean isEmpty();

	boolean isFull();
}