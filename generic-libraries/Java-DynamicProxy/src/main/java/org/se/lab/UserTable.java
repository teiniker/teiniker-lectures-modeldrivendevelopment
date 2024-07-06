package org.se.lab;

import java.util.List;

public interface UserTable
{
	void insert(User entity);
	void update(User entity);
	void delete(User entity);
	User findById(Integer id);
	List<User> findAllUsers();
	List<User> findAllUsersOrderedByName();
}