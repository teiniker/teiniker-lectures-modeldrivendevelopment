package org.se.lab.metamodel;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MetamodelTest
{
	private MStateMachine lightBulb;
	
    @Before
    public void setup()
    {
    	MState init = new MState("init");
    	MState fin = new MState("final");
    	MState off = new MState("OFF");
    	MState on = new MState("ON");
    	
    	List<MState> states = Arrays.asList(init, fin, on, off);

    	MTransition turnOn = new MTransition("turnOn()", "currentOn()");
    	turnOn.setTarget(off);
    	MTransition turnOff = new MTransition("turnOff()", "currentOff()");
    	turnOff.setTarget(on);
    	MTransition burnOut = new MTransition("burnOut()", "currentOff()");
    	burnOut.setTarget(fin);
    	
    	off.getTransitions().add(turnOn); 	
    	on.setTransition(Arrays.asList(turnOff, burnOut));

    	lightBulb = new MStateMachine();
    	lightBulb.setStates(states);
    	lightBulb.setInitState(init);
    	lightBulb.setFinalState(Arrays.asList(fin));
    }
    
    @Test
    public void testInitState()
    {
    	Assert.assertEquals("init", lightBulb.getInitState().getName());
    }
    
    @Test
    public void testStates()
    {
    	Assert.assertEquals(4, lightBulb.getStates().size());
    	Assert.assertEquals("ON", lightBulb.getStates().get(2).getName());
    	Assert.assertEquals("OFF", lightBulb.getStates().get(3).getName());
    }
    
    @Test
    public void testStateTransitions()
    {
    	MState on = lightBulb.getStates().get(2);
    	Assert.assertEquals(2, on.getTransitions().size());
    	Assert.assertEquals("turnOff()", on.getTransitions().get(0).getTrigger());
    	Assert.assertEquals("burnOut()", on.getTransitions().get(1).getTrigger());
    	
    	MState off = lightBulb.getStates().get(3);
    	Assert.assertEquals(1, off.getTransitions().size());
    	Assert.assertEquals("turnOn()", off.getTransitions().get(0).getTrigger());
    }
    
    @Test
    public void testFinalState()
    {
    	Assert.assertEquals(1, lightBulb.getFinalStates().size());
    	Assert.assertEquals("final", lightBulb.getFinalStates().get(0).getName());
    }
}
