package org.se.lab.codegenerator;


public class StackMonitorDecorator extends AbstractStackDecorator {

	public StackMonitorDecorator(Stack stack) {
		super(stack);
	}

	@Override
	public void push(int value) {
		long time, timediff;

		System.out.println("method: push");
		System.out.println("parameter value: " + value);

		time = System.currentTimeMillis();
		super.push(value);
		timediff = System.currentTimeMillis() - time;

		System.out.println("time: " + timediff + "ms");
	}

	@Override
	public int pop() {
		long time, timediff;
		int pop;

		System.out.println("method: pop");

		time = System.currentTimeMillis();
		pop = super.pop();
		timediff = System.currentTimeMillis() - time;

		System.out.println("time: " + timediff + "ms");
		System.out.println("return: " + pop);
		return pop;
	}

	@Override
	public int top() {
		long time, timediff;
		int top;

		System.out.println("method: top");

		time = System.currentTimeMillis();
		top = super.top();
		timediff = System.currentTimeMillis() - time;

		System.out.println("time: " + timediff + "ms");
		System.out.println("return: " + top);
		return top;
	}

	@Override
	public boolean isEmpty() {
		long time, timediff;
		boolean isEmpty;

		System.out.println("method: isEmpty");

		time = System.currentTimeMillis();
		isEmpty = super.isEmpty();
		timediff = System.currentTimeMillis() - time;

		System.out.println("time: " + timediff + "ms");
		System.out.println("return: " + isEmpty);
		return isEmpty;
	}

	@Override
	public boolean isFull() {
		long time, timediff;
		boolean isFull;

		System.out.println("method: isFull");

		time = System.currentTimeMillis();
		isFull = super.isFull();
		timediff = System.currentTimeMillis() - time;

		System.out.println("time: " + timediff + "ms");
		System.out.println("return: " + isFull);
		return isFull;
	}
}
