package org.se.lab;

public class CharacterQueue
{
    private char[] buffer;
    private int start;
    private int stop;
    private int length;
    
    public CharacterQueue(int size)
    {
        if(size < 0)
            throw new IllegalArgumentException();
        buffer = new char[size];
        length = 0;
        start = 0; 
        stop = 0;
    }
    
    public void enqueue(char value)
    {
        if(isFull())
            throw new IllegalStateException("buffer is full");
     
        buffer[start] = value;
        start = (start+1) % buffer.length;
        length++;
    }
    
    public char dequeue()
    {
        if(isEmpty())
            throw new IllegalStateException("buffer is empty");
        
        char value = buffer[stop];
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
