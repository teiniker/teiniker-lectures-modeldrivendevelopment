package org.se.lab;

import org.se.lab.MInteger;
import org.se.lab.MString;

public class JavaGeneratorHelper
{
    private JavaGeneratorHelper() {}
    
    
    /*
     * Utility Methods
     */
    public static String getPropertyName(String name)
    {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
    
    
    /*
     * Mapping Methods (from EType to Java type names)
     */
    
    public static String getJavaTypeName(MInteger type)
    {
        return "int";
    }
    
    public static String getJavaTypeName(MString type)
    {
        return "String";
    }
    
}
