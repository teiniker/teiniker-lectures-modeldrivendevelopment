package org.se.lab.data;

import java.util.List;

public abstract class UserDAODecorator
	implements UserDAO
{
	/*
	 * Reference: ---[1]> dao:UserDAO
	 */
	private UserDAO dao;
	
	public UserDAODecorator(UserDAO dao)
	{
		if(dao == null)
			throw new IllegalArgumentException("Parameter UserDAO is null!");
		
		this.dao = dao;
	}
	
	
	@Override
    public void insert(User user)
    {
    	dao.insert(user);
    }
    
    @Override
    public void update(User user)
    {
    	dao.insert(user);
    }
    
    @Override
    public void delete(User user)
    {
    	dao.delete(user);
    }
    
    @Override
    public User findById(int id)
    {
    	return dao.findById(id);
    }
    
    @Override
    public List<User> findAll()
    {
    	return dao.findAll();
    }
    
    @Override
    public User createUser(String firstName, String lastName, String username, String password)
    {
    	return dao.createUser(firstName, lastName, username, password);
    }
}
