package org.se.lab.codegenerator;


public abstract class AbstractStackDecorator implements Stack {
	private Stack stack;

	public AbstractStackDecorator(Stack stack) {
		this.stack = stack;
	}

	@Override
	public void push(int value) {
		this.stack.push(value);
	}

	@Override
	public int pop() {
		return this.stack.pop();
	}

	@Override
	public int top() {
		return this.stack.top();
	}

	@Override
	public boolean isEmpty() {
		return this.stack.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.stack.isFull();
	}
}