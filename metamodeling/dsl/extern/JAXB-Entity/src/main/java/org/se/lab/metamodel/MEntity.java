package org.se.lab.metamodel;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="entity")
@XmlAccessorType(XmlAccessType.FIELD)
public class MEntity 
	extends MNamedElement
{
	/*
	 * Constructor
	 */
    protected MEntity()
    {        
    }
    
	public MEntity(String name)
	{
		setName(name);
	}
	
	
	/*
	 * Reference: ---[*]-> properties:MProperty[*]
	 */
	@XmlElementWrapper(name = "properties")
	@XmlElement(name = "property")
	private List<MProperty> properties = new ArrayList<MProperty>();
	public List<MProperty> getProperties()
	{
		return properties;
	}
	public void setProperties(List<MProperty> properties)
	{
		this.properties = properties;
	}	
}
