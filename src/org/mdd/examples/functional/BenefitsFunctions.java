package org.mdd.examples.functional;

public class BenefitsFunctions {
	
	public boolean isEligibleForBenefits(Employee employee) {
		return employee.age > 50;
	}

}
