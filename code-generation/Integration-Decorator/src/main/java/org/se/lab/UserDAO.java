package org.se.lab;

import java.util.List;

public interface UserDAO
{
    void insert(User user);
    void update(User user);
    void delete(long id);
    
    User findById(long id);
    List<User> findAll();
}
