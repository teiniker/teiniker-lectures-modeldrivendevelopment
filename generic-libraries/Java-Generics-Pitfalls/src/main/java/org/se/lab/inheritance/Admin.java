package org.se.lab.inheritance;




//@Entity
//@DiscriminatorValue("Adminstrator")
public class Admin
	extends User
{	
	/** Constants */  
	
	public static final String TABLE_NAME="USER";
	
	
	
	/** Constructors */
	
	public Admin(String name, String password)
	{
		super(name);
		setPassword(password);
	}
	
	public Admin()
	{
		this("unknown", "");
	}

	
	/**
	 * Property: password
	 */
	private String password;
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	
	/*
	 * Housekeeping Methods 
	 */
	
	@Override
	public String toString()
	{
		return getId() + "," + getName() + "," + getPassword();
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}
}
