package org.se.lab;

public interface UserService
{
    @Transactional
    void addUser(User user);
    
    @Transactional
    void removeUser(int id);
    
    void findUserByName(String name);
    boolean isKnownUser(User user);
}
