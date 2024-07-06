# Dynamic Proxy

In Java, a Dynamic Proxy is a mechanism that allows us to create a proxy
(decorator) instance of a specified interface at runtime, without needing 
to define a concrete implementation class beforehand. 

This is part of the **Java Reflection API** and is useful for scenarios where 
we want to add behavior dynamically to the objects, such as logging, 
transaction management, or access control.

Benefits of Dynamic Proxies:
* **Flexibility**: Allows us to define behavior dynamically at runtime.
* **Reusability**: The same proxy logic can be applied to different objects 
  and methods.
* **Separation of Concerns**: Keeps the proxy logic separate from the core 
  business logic.

_Example:_ Logging decorator
```Java
public class LoggingDecorator 
	implements InvocationHandler
{
	private Object impl;
	private LoggingDecorator(Object impl)
	{
		this.impl = impl;
	}

	public static Object newInstance(Object impl)
	{
		return Proxy.newProxyInstance(
				impl.getClass().getClassLoader(),
				impl.getClass().getInterfaces(),
				new LoggingDecorator(impl));
	}

	@Override
	public Object invoke(Object proxy, Method m, Object[] args)
		throws IllegalArgumentException
	{
		try
		{
			System.out.println("[" + new Date() + "] before method: " + m.getName());
			Object  result = m.invoke(impl, args);
			return result;
		}
		catch (InvocationTargetException e)
		{
			throw new IllegalStateException("Can't invoke method: ", e);
		} 
		catch (Exception e)
		{
			throw new IllegalStateException("Unexpected invocation exception: " + e.getMessage());
		}  
		finally
		{
			System.out.println("[" + new Date() + "] after method: " + m.getName());
		}
	}
}
```

* **Static Factory Method**: This static `newInstance()` method is used to create a new 
    proxy instance.
    `Proxy.newProxyInstance()` is called with three arguments:
    * **ClassLoader**: The class loader of the `impl` object.
    * **Interfaces**: The interfaces implemented by the `impl` object.
    * **InvocationHandler**: A new instance of `LoggingDecorator` which will handle method invocations.

* **invoke() Method**: This method is called whenever a method is invoked on the proxy instance.
    * **Logging Before Invocation**: Before invoking the method on the real object, it logs the 
      current date and time and the method name.
    * **Method Invocation**: It invokes the actual method on the real object using reflection 
      `m.invoke(impl, args)`.
    * **Logging After Invocation**: Finally, it logs the current date and time and the method name again, 
      whether the invocation was successful or threw an exception.

Dynamic proxies are a powerful feature in Java, enabling a wide range of dynamic 
behaviors to be implemented in a clean and modular way.

## References

* [Baeldung: Dynamic Proxies in Java](https://www.baeldung.com/java-dynamic-proxies)
* [ORACLE: Dynamic Proxy Classes](https://docs.oracle.com/javase/8/docs/technotes/guides/reflection/proxy.html)

*Egon Teiniker, 2017-2024, GPL v3.0*