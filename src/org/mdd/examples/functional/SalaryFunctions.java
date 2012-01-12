package org.mdd.examples.functional;

public class SalaryFunctions {
	
	public static int computeBonus(Employee employee, float factor) {
		return Math.round(employee.salary * factor * employee.targetBonus);
	}
	
	public static int getWeeklySalary(Employee employee) {
		return Math.round(employee.salary / 52f);
	}

}
