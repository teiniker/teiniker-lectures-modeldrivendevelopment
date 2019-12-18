package org.se.lab.data;

import java.util.List;

import org.apache.log4j.Logger;

public class UserDAOMonitoringDecorator
	extends UserDAODecorator
{
    private final Logger LOG = Logger.getLogger(UserDAOMonitoringDecorator.class);

    
	public UserDAOMonitoringDecorator(UserDAO dao)
	{
		super(dao);
	}
	
	
	@Override
    public User findById(int id)
    {
		long start = System.currentTimeMillis();
		User user = super.findById(id);
		long stop = System.currentTimeMillis();
		
		LOG.info("findById(): " + (stop - start) + "ms");
		return user;
    }
    
    @Override
    public List<User> findAll()
    {
    	long start = System.currentTimeMillis();
    	List<User> list = super.findAll();
    	long stop = System.currentTimeMillis();
    	
    	LOG.info("findAll(): " + (stop - start) + "ms");
    	return list;
    }
}
