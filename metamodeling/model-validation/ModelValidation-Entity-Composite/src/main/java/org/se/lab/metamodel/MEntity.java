package org.se.lab.metamodel;

import java.util.ArrayList;
import java.util.List;

public class MEntity 
	extends MNamedElement {
	/*
	 * Constructor
	 */
	public MEntity(String name) {
		setName(name);
	}


	/*
	 * Reference: ---[*]-> properties:MProperty[*]
	 */
	private List<MProperty> properties = new ArrayList<MProperty>();

	public List<MProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<MProperty> properties) {
		if (properties == null)
			throw new IllegalArgumentException();
		this.properties = properties;
	}

	// Model Validation
	public void validate()
	{
		if (KEY_WORDS.contains(getName()))
			throw new IllegalStateException("MEntity.name is a keyword: " + getName());

		// Check name
		getProperties().forEach(p -> p.validate());

		// Check isId
		int numberOfIds = 0;
		for(MProperty p : getProperties())
		{
			if (p.isId())
				numberOfIds++;
		}
		if(numberOfIds == 0)
			throw new IllegalStateException("MEntity has no id!");
		if(numberOfIds > 1)
			throw new IllegalStateException("MEntity has more than one ids!");
	}
}