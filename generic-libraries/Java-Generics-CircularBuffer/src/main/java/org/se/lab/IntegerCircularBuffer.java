package org.se.lab;

public class IntegerCircularBuffer
{
    private int[] buffer;
    private int start;
    private int stop;
    private int length;
    
    public IntegerCircularBuffer(int size)
    {
        if(size < 0)
            throw new IllegalArgumentException();
        buffer = new int[size];
        length = 0;
        start = 0; 
        stop = 0;
    }
    
    public void enque(int value)
    {
        if(isFull())
            throw new IllegalStateException("buffer is full");
     
        buffer[start] = value;
        start = (start+1) % buffer.length;
        length++;
    }
    
    public int deque()
    {
        if(isEmpty())
            throw new IllegalStateException("buffer is empty");
        
        int value = buffer[stop];
        buffer[stop] = 0;
        stop = (stop+1) % buffer.length;
        length--;
        return value;
    }
    
    
    public boolean isEmpty()
    {
        return length == 0;
    }
    
    public boolean isFull()
    {
        return length == buffer.length;
    }
    
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        for(int i=0 ; i<buffer.length; i++)
            s.append(buffer[i]).append(" ");
        return s.toString();
    }
}
