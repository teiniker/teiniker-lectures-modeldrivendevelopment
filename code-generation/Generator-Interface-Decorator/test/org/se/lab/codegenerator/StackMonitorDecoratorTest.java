package org.se.lab.codegenerator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackMonitorDecoratorTest {
	
	private Stack stack;
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	private PrintStream defaultOut;
	
	@Before
	public void setup() {
		StackWrapperImpl stackWrapperImpl = new StackWrapperImpl();
		this.stack = new StackMonitorDecorator(stackWrapperImpl);

		this.stack.push(2);
		this.stack.push(3);
		this.stack.push(5);
		this.stack.push(7);
		this.stack.push(11);
		this.stack.push(13);
		this.stack.push(17);
		System.out.println();System.out.println();System.out.println();
		
		this.defaultOut = System.out;
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(this.defaultOut);
	}
	
	@Test
	public void testPush() {
		this.stack.push(42);
	    Assert.assertEquals("method: push\n"+
							"parameter value: 42\n"+
							"time: 0ms\n"
							, this.outContent.toString());
	}

	@Test
	public void testPop() {
		this.stack.pop();
	    Assert.assertEquals("method: pop\n"+
							"time: 0ms\n"+
				    		"return: 17\n"
							, this.outContent.toString());
	}

	@Test
	public void testTop() {
		this.stack.top();
	    Assert.assertEquals("method: top\n"+
							"time: 0ms\n"+
				    		"return: 17\n"
							, this.outContent.toString());
	}

	@Test
	public void TestIsEmpty() {
		this.stack.isEmpty();
	    Assert.assertEquals("method: isEmpty\n"+
							"time: 0ms\n"+
				    		"return: false\n"
							, this.outContent.toString());
	}

	@Test
	public void TestIsFull() {
		this.stack.isFull();
	    Assert.assertEquals("method: isFull\n"+
							"time: 0ms\n"+
				    		"return: true\n"
							, this.outContent.toString());
	}
	
}
