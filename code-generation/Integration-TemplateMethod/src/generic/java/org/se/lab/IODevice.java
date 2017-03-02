package org.se.lab;

public interface IODevice
{
    public String readLine(String prompt);
    public void writeLine(String msg);
    public void writeError(String err);
}