package org.se.lab;

/*
 * The problem here is that we cannot create instances of E[]:
 *     stack = new E[MAX_SIZE];  // doesn't work
 * Therefore, we use the workaround used in the ArrayList<> implementation:
 *  - we use an array of Object
 *  - and cast the result of pop to type E (which creates a compile time warning!)
 *  - with @SuppressWarnings we can hide this warning (which is a kind of a hack!) 
 */

public class GenericStack<E>
{
    private E[] elementData;
    private int elementCount;
    
    
    /**
     * Constructor that initializes the stack with the given size.
     */
    @SuppressWarnings("unchecked")
	public GenericStack(int capacity)
    {
        if(capacity <= 0)
            throw new IllegalArgumentException("capacity <= 0");
     
        elementData = (E[]) new Object[capacity];
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
    public void push(E item)
    {
        if(elementCount == elementData.length)
            throw new IllegalStateException();
        
        elementData[elementCount++] = item;
    }
    
    
    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     */
    public E pop()
    {
        if(elementCount == 0)
            throw new IllegalStateException();
        
        return elementData[--elementCount];
    }    
}
