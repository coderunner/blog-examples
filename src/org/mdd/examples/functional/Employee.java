package org.mdd.examples.functional;

public class Employee {

	public final String name;
	public final int age;
	public final int salary;
	public final float targetBonus;
	
	public Employee(String name, int age, int salary, float targetBonus) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.targetBonus = targetBonus;
	}
}
