/*
 * We can use the GNU cpp to perform inline generation for Java source code too!
 * 
 * $ cd Generator-cpp
 * $ cpp -P -C src/main/resources/templates/Main.java src/main/java/org/se/lab/Main.java
 */

package org.se.lab;

#include "Macros.java"

//#define DEBUGGING

public class Main
{
    public static void main(String[] args)
    {
    	CHECK_NULL(args, "args is null!");
    	
#ifdef DEBUGGING
        INFO("Hello from the main method!");
#endif
    }
}
