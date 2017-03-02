package org.se.lab.codegenerator;

public class StackWrapperImpl implements Stack {

	private java.util.Stack<Integer> stack = new java.util.Stack<>();
	
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
		return this.stack.peek();
	}

	@Override
	public boolean isEmpty() {
		return this.stack.isEmpty();
	}

	@Override
	public boolean isFull() {
		// XXX that's not right:
		return !this.stack.isEmpty();
	}

}
