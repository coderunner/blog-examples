package org.mdd.examples.functional;

public class SalaryFunctions {
	
	private final float factor;
	
	public SalaryFunctions(float factor) {
		this.factor = factor;
	}
	
	public int computeBonus(Employee employee) {
		return Math.round(employee.salary * factor * employee.targetBonus);
	}
	
	public int getWeeklySalary(Employee employee) {
		return Math.round(employee.salary / 52f);
	}
}
