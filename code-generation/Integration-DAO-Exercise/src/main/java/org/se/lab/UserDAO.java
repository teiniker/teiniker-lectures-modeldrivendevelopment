package org.se.lab;

import java.util.List;


public interface UserDAO
{
	User insert(User user);
	User update(User user);
	void delete(User user);
	
	User findById(int id);
	List<User> findByLastname(String name);
	User findByUsername(String name);
	List<User> findAll();
	
	User createUser(String username, String password);
}
