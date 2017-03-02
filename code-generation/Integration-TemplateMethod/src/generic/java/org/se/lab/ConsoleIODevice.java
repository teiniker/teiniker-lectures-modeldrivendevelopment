package org.se.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public final class ConsoleIODevice implements IODevice
{
    private PrintStream stdout = System.out;
    private PrintStream stderr = System.err;    
    private InputStream stdin = System.in;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(stdin));
    
    
    public String readLine(String prompt) 
    {
        
        System.out.print(prompt);
        String line;
        try
        {
            line = reader.readLine();
        } catch (IOException e)
        {
            throw new RuntimeException("Read line problem!");
        }
        return line;
    }

    public void writeLine(String msg)
    {
        stdout.println(msg);
    }

    public void writeError(String err)
    {
        stderr.println(err);
    }
}
