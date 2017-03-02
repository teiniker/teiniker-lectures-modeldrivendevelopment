package org.se.lab;

/*
 * In mathematics and computer science, a tuple is an ordered list of 
 * elements. In set theory, an (ordered) n-tuple is a sequence (or 
 * ordered list) of n elements, where n is a positive integer.
 */
public final class ObjectTuple
{
    /*
     * Constructor
     */
    public ObjectTuple(Object a, Object b)
    {
        if(a == null || b == null)
            throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
    }

    
    /*
     * First element of the 2-tuple
     */
    private final Object a;
    public Object getFirstElement()
    {
        return a;
    }
    
    /*
     * Second element of the 2-tuple
     */
    private final Object b;
    public Object getSecondElement()
    {
        return b;
    }
    
    
    /*
     * Object's methods
     */

    @Override
    public String toString()
    {
        return "(" + a + "," + b + ")";
    }
}
