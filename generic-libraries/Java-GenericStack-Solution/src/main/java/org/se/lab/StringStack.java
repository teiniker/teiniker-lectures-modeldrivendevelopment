package org.se.lab;

public class StringStack
{
    private String[] elementData;
    private int elementCount;
    
    
    /**
     * Constructor that initializes the stack with the given size.
     */
    public StringStack(int capacity)
    {
        if(capacity <= 0)
            throw new IllegalArgumentException("size <= 0");
     
        elementData = new String[capacity];
        elementCount = 0;
    }
    
    
    /**
     * Tests if this stack is empty.
     */
    public boolean isEmpty() 
    {
        return (elementCount == 0);
    }
    
    
    /**
     * Pushes an item onto the top of this stack.
     */
    public void push(String item)
    {
        if(elementCount == elementData.length)
            throw new IllegalStateException();
        
        elementData[elementCount++] = item;
    }
    
    
    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     */
    public String pop()
    {
        if(elementCount == 0)
            throw new IllegalStateException();
        
        return elementData[--elementCount];
    }    
}
