package org.se.lab;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class MProperty 
	extends MNamedElement
{
	/*
	 * Constructor
	 */
    protected MProperty() {}
    
	public MProperty(String name, MType type)
	{
		setName(name);
		setType(type);		
	}
	
	
	/*
	 * Property: type:MType
	 */
	@XmlElement
	private MType type;
	public MType getType()
	{
		return type;
	}
	public void setType(MType type)
	{
		if(type == null)
			throw new IllegalArgumentException();
		this.type = type;
	}	
	
	
	/*
	 * Property: id:boolean
	 */
	@XmlAttribute
	private boolean id;
	public boolean isId()
	{
		return id;
	}
	public void setId(boolean id)
	{
		this.id = id;
	}	
}
