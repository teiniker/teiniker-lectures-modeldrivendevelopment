package org.se.lab;

public class MProperty
	extends MNamedElement
{

    public MProperty(String name, MType type)
    {
        setName(name);
        setType(type);
    }
    
    
    /*
     * Association: MProperty ---[1]-> MType
     */
    private MType type;
    public MType getType()
    {
        return type;
    }
    public void setType(MType type)
    {
    	if(type == null)
    		throw new IllegalArgumentException("Illegal parameter type!");
        this.type = type;
    }
    
    
    /*
     * Property: readable
     */
    private boolean readable = true;
    public boolean isReadable()
    {
        return readable;
    }
    public void setReadable(boolean readable)
    {
        this.readable = readable;
    }

    
    /*
     * Property: writable
     */
    private boolean writable = true;
    public boolean isWritable()
    {
        return writable;
    }
    public void setWritable(boolean writable)
    {
        this.writable = writable;
    }
    
}
