package org.se.lab;

public class Sequence
{
    /*
     * Sequence generator
     */
    private static long sequence = 0;
    
    public static void init(long value)
    {
        if(value < 0)
            throw new IllegalStateException();        
        sequence = value;
    }
    
    public static long next()
    {
        return sequence++;
    }
}
