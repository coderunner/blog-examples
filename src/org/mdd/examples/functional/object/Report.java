package org.mdd.examples.functional.object;

import java.util.List;

public class Report {

	private final List<Employee> employees;

	public Report(List<Employee> employees) {
		this.employees = employees;
	}
	
	public String generateGlobalReport(float factor) {
		StringBuilder sb = new StringBuilder();
		for(Employee e : employees)
		{
			sb.append("Name: ").append(e.getName())
			.append("; Bonus: ").append(e.computeBonus(factor))
			.append("; Is Eligible: ").append(e.isEligibleForBenefits())
			.append("\n");
		}
		return sb.toString();
	}
}
