package org.se.lab;

import java.util.List;

public class UserDAOMonitoringDecorator
    extends UserDAODecorator
{
    /*
     * Time measurement
     */
    private long start;
    private long stop;
    private void logTimeInterval(String msg)
    {
        long interval = stop-start;
        System.out.println(msg + interval + "[ms]");
    }
    
    
    /*
     * Constructor
     */
    public UserDAOMonitoringDecorator(UserDAO dao)
    {
        super(dao);
    }

    /*
     * Note that we only monitor two of the UserDAO methods.
     * All other methods are handled by the UserDAODecorator base class.
     */
    
    @Override
    public User findById(long id)
    {
        start = System.currentTimeMillis();
        User user = super.findById(id);
        stop = System.currentTimeMillis();
        logTimeInterval("findById takes ");
        return user;
    }
    
    @Override
    public List<User> findAll()
    {
        start = System.currentTimeMillis();
        List<User> users = super.findAll();
        stop = System.currentTimeMillis();
        logTimeInterval("findAll takes ");
        return users;
    }
}
