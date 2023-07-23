package org.se.lab;

/*
 * @generated
 */
public abstract class AbstractLogin
{
    /*
     * Attributes
     */
    protected String username;
    protected String password;
        
    /*
     * Template method
     */
    public final void execute()
    {
        readUsername();
        readPassword();
        
        if(checkInputData())
        {
            errorInvalidUserData();
        }
        else
        {         
            if(checkUserData())
            {
                welcomeUser();
            }
            else
            {
                errorLoginFailed();
            }
        }       
    }
    
    
    /*
     * Actions
     */
    
    protected abstract void readUsername();    
    protected abstract void readPassword();
    protected abstract boolean checkInputData();
    protected abstract boolean checkUserData();  
    protected abstract void welcomeUser();
    protected abstract void errorInvalidUserData();
    protected abstract void errorLoginFailed();
}
