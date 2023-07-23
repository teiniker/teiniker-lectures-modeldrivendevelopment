package org.se.lab;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

class UserDAOImpl implements UserDAO
{
	/*
	 * Constructor
	 */
	public UserDAOImpl(EntityManager em)
	{
		this.em = em;
	}

	/*
	 * Constructor injection
	 */
	private EntityManager em;

	public EntityManager getEntityManager()
	{
		return em;
	}

	
	/*
	 * Factory methods
	 */

	@Override
	public User createUser(String username, String password)
	{
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		insert(u);
		return u;
	}

	
	/*
	 * CRUD methods
	 */

	@Override
	public User insert(User entity)
	{
		em.persist(entity);
		return entity;
	}

	@Override
	public User update(User entity)
	{
		return em.merge(entity);
	}

	@Override
	public void delete(User entity)
	{
		em.remove(entity);
	}

	@Override
	public User findById(int id)
	{
		return em.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll()
	{
		final String hql = "SELECT u FROM " + User.class.getName() + " AS u";
		return em.createQuery(hql).getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> findByLastname(String name)
	{
		final String hql = "SELECT u FROM " + User.class.getName()
				+ " AS u WHERE upper(lastname) like upper(:name)";

		Query q = getEntityManager().createQuery(hql);
		q.setParameter("name", name);
		return q.getResultList();
	}

	@Override
	public User findByUsername(String name)
	{
		final String hql = "SELECT u FROM " + User.class.getName()
				+ " AS u WHERE upper(username) like upper(:name)";

		Query q = getEntityManager().createQuery(hql);
		q.setParameter("name", name);
		return (User) q.getSingleResult();
	}
}
