package org.se.lab;

public class User
{
    /*
     * Constructor
     */
    public User(long id, String username, String password)
    {
        if(id < 0 || username == null || password == null)
            throw new IllegalArgumentException();       
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    public User(String username, String password)
    {
        this(Sequence.next(),username,password);
    }
    
    
    /*
     * Property: id:long
     */
    private final long id;
    public long getId()
    {
        return id;
    }
    
    
    /*
     * Property: username:String
     */
    private final String username;
    public String getUsername()
    {
        return username;
    }
    
    
    /*
     * Property: password
     */
    private final String password;
    public String getPassword()
    {
        return password;
    }
    
    
    /*
     * Object methods
     */
    
    @Override
    public String toString()
    {
        return getId() + "," + getUsername() + "," + getPassword();
    }


    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
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
        User other = (User) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
