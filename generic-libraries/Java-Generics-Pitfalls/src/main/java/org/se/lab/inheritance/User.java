package org.se.lab.inheritance;



//@Entity
//@Table(name=User.TABLE_NAME)
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="DISCRIMINATOR", discriminatorType=DiscriminatorType.STRING)
//@DiscriminatorValue("User")
public class User
{	
	/** Constants */  
	
	public static final String TABLE_NAME="USERS";
	
	
	
	/** Constructors */
	
	public User(String name)
	{
		setName(name);
	}
	
	public User()
	{
		this("unknown");
	}

		
	/**
	 * Property: id
	 */
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	
	/**
	 * Property: name
	 */
	private String name;
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	
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
