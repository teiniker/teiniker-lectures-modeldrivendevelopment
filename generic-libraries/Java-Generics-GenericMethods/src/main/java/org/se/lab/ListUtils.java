package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class ListUtils
{    
    /*
     * This method accepts an array of type T[] and returns a list of type List<T>,
     * and does so for any type T.
     * This is indicated by writing <T> at the beginning of the method signature,
     * which declares T as a new type variable.
     * A method which declares a type variable in this way is called a generic method.
     * The scope of the type variable T is local to the method itself.
     */
    public static <T> List<T> asList(T... in)
    {
        List<T> out = new ArrayList<T>();        
        for(T t : in)
        {
            out.add(t);
        }        
        return out;
    }
        

    /*
     * This method takes a collection of numbers, converts each to a double,
     * and sums them up.
     * 
     * Note: Whenever we use an iterator, you get values out of a data structure,
     * so we use a <? extends T> wildcard.
     * <? extends T> means that the source list may have elements of any type that
     * is a subtype of T.
     * 
     * Since we use extends, all of the following parameters are legal:
     *  List<Integer>, List<Double>, List<Number>, etc.
     */
    public static double sum(List<? extends Number> numbers)
    {
        double sum = 0.0;
        for(Number n : numbers)
        {
            sum += n.doubleValue();
        }
        return sum;
    }
    
    
    /*
     * This method takes a list of numbers and an integer n, and puts the first n
     * integers, starting from zero, into the list.
     * 
     * Note: Whenever we use the add method, we put values into a data structure,
     * so we use a <? super T> wildcard.
     * <? super T>  means that the destination list may have elements of any type that is
     * a supertype of T.
     *              
     * Since we use super, all of the following parameters are legal:
     *  List<Integer>, List<Number>, List<Object>
     */
    public static void fill(List<? super Integer> list, int n)
    {
        for(int i = 0; i<n; i++)
        {
            list.add(i);
        }
    }
    
    
    /*
     * This method copies into a destination list all of the elements from a source
     * list.
     * 
     * <? extends T> means that the source list may have elements of any type that is a 
     *               subtype of T.
     * <? super T>  means that the destination list may have elements of any type that is
     *              a supertype of T.
     *              
     * Get and Put Principle:
     * Use an 'extends' wildcard when you only get values out of a data structure,
     * use a 'super' wildcard when you only put values into a data structure, and
     * don't use a wildcard when you both get and put.             
     */
    public static <T> void copy(List<? extends T> src, 
    							List<? super T> dest)
    {
        for(int i = 0; i<src.size(); i++)
        {
            dest.add(src.get(i));
        }
    }
}
