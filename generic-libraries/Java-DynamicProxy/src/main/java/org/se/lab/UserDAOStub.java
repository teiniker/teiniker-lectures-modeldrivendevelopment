package org.se.lab;

import java.util.Arrays;
import java.util.List;

public class UserDAOStub
	implements UserDAO
{
	/*
	 * Constructor
	 */
	public UserDAOStub()
	{
		System.out.println("stub> UserDAOImpl()");
	}
	
	public void delete(User user)
	{
		System.out.println("stub> delete(" + user + ")");
	}

	public List<User> findAllUsers()
	{
		System.out.println("stub> findAllUsers()");
		return Arrays.asList(new User("oskar"), new User("egon"));
	}

	public List<User> findAllUsersOrderedByName()
	{
		System.out.println("stub> findAllUsersOrderedByName()");
		return Arrays.asList(new User("egon"), new User("oskar"));
	}

	public User findById(Integer id)
	{
		System.out.println("stub> findById(" + id + ")");
		return new User("egon");
	}

	public void insert(User user)
	{
		System.out.println("stub> insert(" + user + ")");
	}

	public void update(User user)
	{
		System.out.println("stub> update(" + user + ")");
	}
}
