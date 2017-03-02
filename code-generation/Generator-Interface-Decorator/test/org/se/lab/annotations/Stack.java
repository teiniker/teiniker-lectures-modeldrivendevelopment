package org.se.lab.annotations;

@Decorator
public interface Stack {
	void push(int value);

	int pop();

	int top();

	boolean isEmpty();

	boolean isFull();
}