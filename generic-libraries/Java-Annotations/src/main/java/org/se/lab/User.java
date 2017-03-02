package org.se.lab;

@Version(major=2, minor=3, bugfix=17)
public class User
{
	/* 
	 * Constructors 
	 */
	public User(final int id, final String name)
	{
		setId(id);
		setName(name); 
	}
	
	
	/*
	 * Property: id
	 */
	private int id;
	public int getId()
	{
		return id;
	}
	public void setId(final int id)
	{
		this.id = id;
	}
	
	
	/*
	 * Property: name
	 */
	private String name;
	public String getName()
	{
		return name;
	}
	public void setName(final String name)
	{
		if(name == null)
			throw new NullPointerException("name");
		this.name = name;
	}

	
	/* 
	 * Housekeeping Methods 
	 */
	
	@Override
	public String toString()
	{
		return getId() + "," + getName();
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
