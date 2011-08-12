package org.mdd.examples.dependency;

import org.inject.Injector;

public class MainClass
{
	private Injector injector;
	
	/** MANUAL OBJECT TREE SETUP **/
	public void manualObjectTreeSetup()
	{
		//create the dependency tree
		//this can get really annoying
		AnotherDependencyInterface anotherDependency =
			new AnotherDependency();
		
		DependencyInterface dependency =	
			new Dependency(anotherDependency);
		
		//create the object
		ExampleClass object = new ExampleClass(dependency);
	}
	
	/** USING DEPENDENCY INJECTION **/
	public void initInject()
	{
		//setup injection bindings, this is done once at initialization
		Injector.Builder builder = new Injector.Builder();
		injector = builder.addClassBinding(AnotherDependencyInterface.class,
					AnotherDependency.class)
				.addClassBinding(DependencyInterface.class,
					Dependency.class)
				.addClassBinding(ExampleClass.class,
					ExampleClass.class)
				.build();
	}
	
	public void injectObjectTreeSetup()
	{
		//create the required object
		//the injector will create the require dependencies and inject 
		//them in the newly create instance
		ExampleClass object = injector.createObject(ExampleClass.class);		
	}
	
	/** MAIN **/
	public static void main(String args[])
	{
		MainClass main = new MainClass();
		
		//manual setup
		main.manualObjectTreeSetup();
		
		//using DI library
		main.initInject();
		main.injectObjectTreeSetup();
	}
}
