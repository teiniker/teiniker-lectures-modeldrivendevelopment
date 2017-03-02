package org.se.lab;

import java.util.List;
import java.util.ArrayList;

//5 points for the AntBuilder
public class AntBuilder
{
	private String name;
	private String baseDir;
	private String description = ""; // default value
	private List<PropertyBuilder> properties = new ArrayList<PropertyBuilder>();
	
	
	// Ant project name 
	public AntBuilder name(String name)
	{		
		this.name = name;
		return this;
	}
	
	// Ant project baseDir
	public AntBuilder baseDir(String baseDir)
	{
		this.baseDir = baseDir;
		return this;
	}
	
	// Ant description
	public AntBuilder description (String description)
	{
		this.description = description;
		return this;
	}
	
	// Ant properties
	public PropertyBuilder property()	// 2 Points (including List<PropertyBuilder>)
	{
		PropertyBuilder pb = new PropertyBuilder();
		properties.add(pb);
		return pb;
	}
	
	
	public MProject toAnt()		// 2 Points
	{
		MProject ant = new MProject();
		
		ant.setName(name);
		ant.setBaseDir(baseDir);
		
		//MDescription description = new MDescription();
		MDescription desc = new MDescription();
		desc.setText(description);
		ant.setDescription(desc);
		
		// properties
		for (PropertyBuilder pb : this.properties)
		{
			ant.getProperties().add(pb.toProperty());
		}
		
		return ant;
	}

	
	/*
	 * Nested Builder Class
	 * 	5 Points for the whole implementation
	 */
	
	public class PropertyBuilder
	{		
		private String name;
		private String value;
		
		// Property name 
		public PropertyBuilder name(String name)
		{		
			this.name = name;
			return this;
		}
		
		public PropertyBuilder value(String value)
		{
			this.value = value;
			return this;
		}
		
		
		public MProperty toProperty()	// 1 Point
		{
			MProperty property = new MProperty();
			
			property.setName(name);
			property.setValue(value);
			
			return property;
		}
		
		public PropertyBuilder property()	// 1 Point
		{
			return AntBuilder.this.property();
		}
		
		public MProject toAnt()		// 1 Point
		{
			return AntBuilder.this.toAnt();
		}
	}
}
