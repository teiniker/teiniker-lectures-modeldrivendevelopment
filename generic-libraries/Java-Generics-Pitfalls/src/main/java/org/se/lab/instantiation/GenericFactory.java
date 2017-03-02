package org.se.lab.instantiation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GenericFactory
{
		
//	public static <E> E createElement()
//	{
//		// Error: cannot instantiate the type E!
//		E e = new E();
//		return e;
//	}

	public static <E> E createElement(Class<E> elementType)
	{
		E element = null;
		try
		{
			element = elementType.newInstance();
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		} 
		return element;
	}
	
	
	public static <E> List<E> createList(E element, int number)
	{
		List<E> list = new ArrayList<E>();
		for(int i = 0; i<number; i++)
			list.add(element);
		return list;
	}
	

	/**
	* We cannot instantiate an array of a type represented by a type parameter. 
	* The compiler doesn't know what type V really represents, so it cannot 
	* instantiate an array of V.
	*/
//	public static <E> E[] fillArray(E element, int number)
//	{
//		// Error: cannot create a generic array of E!
//		E[] array = new E[number];
//		for(int i = 0; i<number; i++)
//			array[i] = element;
//		return array;		
//	}
	
	@SuppressWarnings("unchecked")
	public static <E> E[] createArray(Class<E> elementType, E element, int number)
	{
		E[] array = (E[])Array.newInstance(elementType, number);
		for(int i = 0; i<number; i++)
			array[i] = element;
		return array;		
	}	
}
