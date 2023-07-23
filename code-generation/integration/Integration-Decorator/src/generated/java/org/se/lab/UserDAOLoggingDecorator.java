package org.se.lab;

import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAOLoggingDecorator
    extends UserDAODecorator
{
    private Logger logger;
    
    /*
     * Constructor
     */
    public UserDAOLoggingDecorator(UserDAO dao)
    {
        super(dao);
        logger = Logger.getLogger("org.se.lab");
        logger.setLevel(Level.ALL);
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        logger.addHandler(ch);
    }

    @Override
    public void insert(User user)
    {
        logger.fine("insert(\"" + user + "\")");
        super.insert(user);
    }
    
    @Override
    public void update(User user)
    {
        logger.fine("update(\"" + user + "\")");
        super.update(user);        
    }
    
    @Override
    public void delete(long id)
    {
        logger.fine("delete(" + id + ")");
        super.delete(id);
    }
    
    @Override
    public User findById(long id)
    {
        logger.fine("findById(" + id + ")");
        User user = super.findById(id);
        logger.fine("   result = \"" + user + "\")");
        return user;
    }
    
    @Override
    public List<User> findAll()
    {
        logger.fine("findAll()");
        List<User> users = super.findAll();
        logger.fine("   result = " + users + ")");
        return users;
    }
}
