package org.se.lab;



public class User
{		
	/* 
	 * Constructors 
	 */
	
	public User(String name)
	{
		this.name = name;
	}
	
	public User()
	{
		this("unknown");
	}

		
	/*
	 * Property: id
	 */
	private int id;
	public int getId() 
	{ 
		System.out.println("User.getId() = " + id);
		return id;
	}
	public void setId(int id) 
	{ 
		System.out.println("User.setId(" + id + ")");
		this.id = id; 
	}

	
	/*
	 * Property: name
	 */
	private String name;
	public String getName() 
	{ 
		System.out.println("User.getName() = " + name);
		return name; 
	}
	public void setName(String name) 
	{ 
		if(name == null)
			throw new NullPointerException("name");
		System.out.println("User.setName(" + name + ")");
		this.name = name; 
	}

	
	/*
	 * Housekeeping Methods 
	 */
	
	@Override
	public String toString()
	{
		return id + "," + name;
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
