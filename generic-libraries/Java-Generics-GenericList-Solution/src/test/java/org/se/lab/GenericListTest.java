package org.se.lab;

import org.junit.Assert;
import org.junit.Test;


public class GenericListTest
{
    
   @Test
   public void testDoubleSum()
   {
	   GenericList<Double> list = new GenericListImpl<Double>();
       list.add(7.0).add(3.0).add(11.0); 
	   
	   double sum = list.sum();
   	
	   Assert.assertEquals(7.0+3.0+11.0, sum, 10E-6);
   }


   @Test
   public void testIntegerSum()
   {
	   GenericList<Integer> list = new GenericListImpl<Integer>();
       list.add(7).add(3).add(11); 
	   
	   double sum = list.sum();
   	
	   Assert.assertEquals(7+3+11, sum, 10E-6);
   }


}
