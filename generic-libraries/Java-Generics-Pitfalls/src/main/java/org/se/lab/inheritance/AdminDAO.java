package org.se.lab.inheritance;


// Error: the DAO cannot be implemented more than once with different arguments:
// DAO<Administrator> and DAO<User>
public interface AdminDAO
	extends DAO<Admin> //, DAO<User>
{

}
