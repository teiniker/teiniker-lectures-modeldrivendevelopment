package org.se.lab;

import org.junit.Test;


public class ConsoleLoginTest
{
    @Test
    public void testLogin()
    {
        ConsoleLogin login = new ConsoleLogin(new ConsoleIODevice());
        login.execute();
    }
}
