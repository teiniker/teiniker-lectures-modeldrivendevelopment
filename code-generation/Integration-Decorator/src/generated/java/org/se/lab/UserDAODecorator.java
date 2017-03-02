package org.se.lab;

import java.util.List;

public class UserDAODecorator
    implements UserDAO
{
    
    /*
     * Constructor
     */
    public UserDAODecorator(UserDAO dao)
    {
        if(dao == null)
            throw new IllegalArgumentException();
        this.dao = dao;
    }
    
    /*
     * Association: ---[1]-> dao:UserDAO
     */
    private UserDAO dao;


    /*
     * UserDAO methods
     */

    public void insert(User user)
    {
        dao.insert(user);
    }

    public void update(User user)
    {
        dao.update(user);
    }

    public void delete(long id)
    {
       dao.delete(id);
    }

    public User findById(long id)
    {
        return dao.findById(id);
    }

    public List<User> findAll()
    {
        return dao.findAll();
    }
}
