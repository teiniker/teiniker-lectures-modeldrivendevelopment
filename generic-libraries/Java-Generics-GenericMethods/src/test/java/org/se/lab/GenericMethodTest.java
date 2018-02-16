package org.se.lab;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.se.lab.ListUtils;

public class GenericMethodTest
{
	@Test
	public void testStringArrayToList()
    {
        // Note that the generic method forces the same element types for 
        // the parameter array and the result list.
        // List<Object> list = ListUtils.arrayToList(array); // compiler error
        List<String> list = ListUtils.asList("one", "two", "three", "4");
        System.out.println(">> " + list);
        assertEquals("[one, two, three, 4]", list.toString());
    }

	
	@Test
    public void testIntegerArrayToList()
    {
        // Note that explicit type parameters are usually not required.
        // List<Integer> list = ArrayUtils.arrayToList(array);
        List<Integer> list = 
        	ListUtils.<Integer>asList(1, 2, 3);
        System.out.println(">> " + list);
        assertEquals("[1, 2, 3]", list.toString());
    }
    
    
	@Test
    public void testSumOfIntegerList()
    {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(7);
        numbers.add(-2);        
        double result = ListUtils.sum(numbers);
        System.out.println(">> " + result);
        assertEquals(5.0, result, 0.001);
    }

	
	@Test
    public void testSumOfDoubleList()
    {
        List<Double> numbers = new ArrayList<Double>();
        numbers.add(7.77);
        numbers.add(-2.21);        
        double result = ListUtils.sum(numbers);
        System.out.println(">> " + result);
        assertEquals(7.77 - 2.21, result, 0.0001);
    }

    
	@Test
    public void testFillIntegerList()
    {
        List<Integer> ints = new ArrayList<Integer>();
        ListUtils.fill(ints, 5);
        System.out.println(">> " + ints);
        assertEquals("[0, 1, 2, 3, 4]", ints.toString());
    }

//    public void testFillDoubleList()
//    {
//        List<Double> doubles = new ArrayList<Double>();
//        ListUtils.fill(doubles, 5); // compiler error
//        System.out.println(">> " + doubles);
//        assertEquals("[0, 1.0, 2.0, 3.0, 4.0]", doubles.toString());
//    }

	
	@Test
    public void testFillNumberList()
    {
        List<Number> numbers = new ArrayList<Number>();
        ListUtils.fill(numbers, 5);
        System.out.println(">> " + numbers);
        assertEquals("[0, 1, 2, 3, 4]", numbers.toString());
    }

	@Test
    public void testFillObjectList()
    {
        List<Object> objects = new ArrayList<Object>();
        ListUtils.fill(objects, 5);
        System.out.println(">> " + objects);
        assertEquals("[0, 1, 2, 3, 4]", objects.toString());
    }

    
	@Test
    public void testStringListCopy()
    {
        List<String> src = ListUtils.asList("one", "two", "three");
        List<String> dest = new ArrayList<String>();
        
        ListUtils.copy(src, dest);

        System.out.println(">> " + dest);
        assertEquals("[one, two, three]", dest.toString());
    }

    
	@Test
    public void testIntegerListCopy()
    {
        List<Integer> src = ListUtils.asList(1, 2, 3);
        List<Integer> dest = new ArrayList<Integer>();
        
        ListUtils.copy(src, dest);

        System.out.println(">> " + dest);
        assertEquals("[1, 2, 3]", dest.toString());
    }
}
