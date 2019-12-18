package org.se.lab;

import java.util.List;


public interface UserDAO
	extends UserDAOBase
{
	List<User> findByLastname(String name);
	User findByUsername(String name);
}
