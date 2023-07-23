package org.se.lab;

public class GenericLinkedList<E>
{
    /*
     * Association: ---[1]-> firstNode:Node
     */
    private Node firstNode;
    public Node getFirstNode()
    {
        return firstNode;
    }
    public void setFirstNode(Node firstNode)
    {
        if(firstNode == null)
            throw new IllegalArgumentException();
        this.firstNode = firstNode;
    }

    
    /*
     * Property: size:int
     */
    private int size;
    public int size()
    {
        return size;
    }
    
    
    
    public GenericLinkedList<E> add(E value)
    {
        Node node = new Node(value);
        if(firstNode == null)
        {
            firstNode = node;
            size++;
        }
        else
        {
            Node currentNode = firstNode;
            while(currentNode.getNext() != null)
            {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(node);
            size++;
        }
        return this;
    }
    
    
    public E get(int index)
    {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException();
        
        Node currentNode = firstNode;
        for(int i=0; i<index; i++)
        {
            if(currentNode == null)
                throw new IllegalStateException();
            else
                currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }
    
    
    /*
     * Object's methods
     */
    
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("{");
        Node currentNode = firstNode;            
        for(int i=0; i<size; i++)
        {
            s.append(currentNode.getValue());
            if(i < size-1)
                s.append(",");
            currentNode = currentNode.getNext();
        }
        s.append("}");
        return s.toString();
    }
    
    
    /*
     * Nested Node class
     */
    private class Node
    {
        /*
         * Constructor
         */
        public Node(E value)
        {
            setValue(value);
        }
        
        
        /*
         * Property: value:E
         */
        private E value;
        public E getValue()
        {
            return value;
        }
        public void setValue(E value)
        {
            if(value == null)
                throw new IllegalArgumentException();
            this.value = value;
        }

        
        /*
         * Association: next:Node
         */
        private Node next;
        public Node getNext()
        {
            return next;
        }
        public void setNext(Node next)
        {
            if(next == null)
                throw new IllegalArgumentException();
            this.next = next;
        }    
    }
}
