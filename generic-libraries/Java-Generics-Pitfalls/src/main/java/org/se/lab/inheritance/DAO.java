package org.se.lab.inheritance;

import java.util.List;

public interface DAO<E>
{
	void insert(E entity);

	void update(E entity);

	void delete(E entity);

	E findById(Integer id);

	List<E> findAllUsers();
	
	List<E> findAllUsersOrderedByName();
}
