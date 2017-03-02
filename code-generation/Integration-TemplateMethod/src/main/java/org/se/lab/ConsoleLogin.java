package org.se.lab;

import java.util.HashMap;
import java.util.Map;

public class ConsoleLogin
    extends AbstractLogin
{
    /*
     * Simulate a database table
     */
    
    private static final Map<String,String> userTable;
    
    static
    {
        userTable = new HashMap<String, String>();
        userTable.put("homer",  "********");
        userTable.put("marge",  "********");
        userTable.put("bart",   "********");
        userTable.put("lisa",   "********");
        userTable.put("maggie", "********");
    }
    
    /*
     * Constructor
     */
    public ConsoleLogin(IODevice console)
    {
        setConsole(console);
    }
   
    
    /*
     * Association: ---[1]-> console:IOUtils
     */    
    private IODevice console;
    public final void setConsole(IODevice console)
    {
        if(console == null)
            throw new NullPointerException();
        this.console = console;
    }
    public final IODevice getConsole()
    {
        return console;
    }
    
    
    /*
     * Actions
     */

    protected void readUsername()
    {
        username = getConsole().readLine("username> ");
    }

    protected void readPassword()
    {
        password = getConsole().readLine("password> ");
    }

    protected boolean checkInputData()
    {
        return username.length() < 4 || password.length() < 8;
    }
    
    protected boolean checkUserData()
    {
        return userTable.containsKey(username) && userTable.get(username).equals(password);
    }

    protected void welcomeUser()
    {
        getConsole().writeLine("Welcome " + username + "!"); 
    }

    protected void errorInvalidUserData()
    {
        getConsole().writeError("Error: you entered invalid user data!");
        throw new IllegalStateException();
    }

    protected void errorLoginFailed()
    {
        getConsole().writeError("Login failed!");
        throw new IllegalStateException();
    }
}

