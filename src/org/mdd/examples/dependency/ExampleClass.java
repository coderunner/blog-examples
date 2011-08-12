package org.mdd.examples.dependency;

import org.inject.Inject;

public class ExampleClass
{
	private DependencyInterface dependency;
	
	//no dependency injection
	public ExampleClass()
	{
		//this makes the class hard to test
		dependency = new Dependency();
		//...
	}
	
	//inject the concrete dependency
	public ExampleClass(Dependency dependency)
	{
		//this makes the class slightly more testable
		//if proper test tools are used because
		//the dependency can be setup or mocked
		this.dependency = dependency; 
		//...
	}
	
	@Inject
	//inject the interface
	public ExampleClass(DependencyInterface dependency)
	{
		//this makes the class easily testable as a test
		//implementation can be supplied
		this.dependency = dependency; 
		//...
	}	
}
