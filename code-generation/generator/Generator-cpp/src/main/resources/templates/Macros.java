/*
 * This file contains some CPP macros
 */

#define INFO(message) System.out.println("INFO [" + __FILE__ + "]: " +  message)
#define DEBUG(message) System.out.println("DEBUG [" + __FILE__ + "]: " + message)
#define ERROR(message) System.err.println("ERROR [" + __FILE__ + "]: " + message)

#define CHECK_NULL(ref, message) if((ref) == null) throw new NullPointerException(message)
