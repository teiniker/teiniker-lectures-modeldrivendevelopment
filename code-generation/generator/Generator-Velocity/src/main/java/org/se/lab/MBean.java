package org.se.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MBean
    extends MNamedElement
{
    public MBean(String name)
    {
        setName(name);
    }
    
    
    /*
     * Association: MBean ----[*]-> MProperty
     */
    private List<MProperty> properties = new ArrayList<MProperty>();
    public void addProperty(MProperty property)
    {
    	if(property == null)
    		throw new IllegalArgumentException("Invalid parameter property!");
        properties.add(property);
    }
    public List<MProperty> getProperties()
    {
        return Collections.unmodifiableList(properties);
    }
    
}
