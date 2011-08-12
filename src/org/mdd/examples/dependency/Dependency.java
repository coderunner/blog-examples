package org.mdd.examples.dependency;

import org.inject.Inject;

public class Dependency implements DependencyInterface
{
	public Dependency()
	{}
	
	@Inject
	public Dependency(AnotherDependencyInterface dependency)
	{}

}
