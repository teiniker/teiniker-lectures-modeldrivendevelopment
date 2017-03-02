package org.se.lab;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

class UserDAOImpl
	extends UserDAOImplBase
{
	/*
	 * Constructor
	 */
	public UserDAOImpl(EntityManager em)
	{
		super(em);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> findByLastname(String name)
	{
		final String hql = "SELECT u FROM " + getEntityClass().getName() 
				+ " AS u WHERE upper(lastname) like upper(:name)" ;
		
		Query q = getEntityManager().createQuery(hql);
		q.setParameter("name", name);
		return q.getResultList();
	}
	
	@Override
	public User findByUsername(String name)
	{
		final String hql = "SELECT u FROM " + getEntityClass().getName() 
				+ " AS u WHERE upper(username) like upper(:name)" ;	    
		
		Query q = getEntityManager().createQuery(hql);
		q.setParameter("name", name);
		return (User)q.getSingleResult();
	}
}
