package org.mdd.examples.functional.object;

public class ImmutableEmployee {

	private final String name;
	private final int age;
	private final int salary;
	private final float targetBonus;
	
	public ImmutableEmployee(String name, int age, int salary, float targetBonus) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.targetBonus = targetBonus;
	}
	
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

	public int getSalary() {
		return salary;
	}

	public float getTargetBonus() {
		return targetBonus;
	}

	public int getAge() {
		return age;
	}
	
}
