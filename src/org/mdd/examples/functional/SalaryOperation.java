package org.mdd.examples.functional;

public class SalaryOperation {

	private final Employee employee;

	public SalaryOperation(Employee employee) {
		this.employee = employee;
	}
	
	public int computeBonus(float factor) {
		return Math.round(employee.salary * factor * employee.targetBonus);
	}
	
	public int getWeeklySalary() {
		return Math.round(employee.salary / 52f);
	}
}
