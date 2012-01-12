package org.mdd.examples.functional.object;

public class Employee {
	
	private String name;
	private int age;
	private int salary;
	private float targetBonus;
	
	public Employee()
	{}

	public int computeBonus(float factor) {
		return Math.round(salary * factor * targetBonus);
	}
	
	public int getWeeklySalary() {
		return Math.round(salary / 52f);
	}
	
	public boolean isEligibleForBenefits() {
		return age > 50;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public float getTargetBonus() {
		return targetBonus;
	}

	public void setTargetBonus(float targetBonus) {
		this.targetBonus = targetBonus;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
