package org.se.lab;

public class GenericQueueImpl<E> implements GenericQueue<E>
{
    private Object[] buffer;
    private int start;
    private int stop;
    private int length;
    
    public GenericQueueImpl(int size)
    {
        if(size <= 0)
            throw new IllegalArgumentException();
        buffer = new Object[size];
        length = 0;
        start = 0; 
        stop = 0;
    }
    

    @Override
	public void enqueue(E value)
    {
        if(isFull())
            throw new IllegalStateException("buffer is full");
     
        buffer[start] = value;
        start = (start+1) % buffer.length;
        length++;
    }
    
    
    @Override
	@SuppressWarnings("unchecked")
    public E dequeue()
    {
        if(isEmpty())
            throw new IllegalStateException("buffer is empty");
        
        E value = (E)buffer[stop];
        buffer[stop] = null;
        stop = (stop+1) % buffer.length;
        length--;
        return value;
    }
    
    
    @Override
	public boolean isEmpty()
    {
        return length == 0;
    }
    

    @Override
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
