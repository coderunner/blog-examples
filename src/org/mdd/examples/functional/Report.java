package org.mdd.examples.functional;

import java.util.List;

public class Report {

	private final List<Employee> employees;

	public Report(List<Employee> employees) {
		this.employees = employees;
	}
	
	public String generateGlobalReport(float factor, BenefitsFunctions benefitFunctions) {
		StringBuilder sb = new StringBuilder();
		
		for(Employee e : employees)
		{
			//salary operation should contain the factor, not the employee
			//function applies on what, this should be external
			//what are the parameters should be internal
			///f(x) = Ax + B -> A and B should be members defined in the constructor
			SalaryOperation salaryOperation = new SalaryOperation(e);
			sb.append("Name: ").append(e.name)
			.append("; Bonus: ").append(salaryOperation.computeBonus(factor))
			.append("; Is Eligible: ").append(benefitFunctions.isEligibleForBenefits(e))
			.append("\n");
		}
		return sb.toString();
	}
}
