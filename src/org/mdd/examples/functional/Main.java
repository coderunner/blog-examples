package org.mdd.examples.functional;


public class Main {

	public static void main(String[] args) {
				
		Employee e = new Employee("joe", 33, 55000, 0.05f);
		
		//static, simple to use, harder for tests
		//to use only if that is the only way it can be done (e.g. Math.abs())
		//good to extract duplicated code in unrelated places
		int bonus = new SalaryFunctions(0.67f).computeBonus(e);
		
		//easy to use and to mock, same object can be used for many employees
		boolean isEligible = new BenefitsFunctions().isEligibleForBenefits(e);
		
		//easy to use and to mock, many operation can be called for the same employee
		int otherBonus = new SalaryOperation(e).computeBonus(0.67f);
		
		//int otherBonus = new SalaryOperation(0.67f).computeBonus(e);
		
		//different subtypes of Employee mean switch in functions so adding type -> possibly modify all functions
		//different function added to process on Employee, means potentially changing all subtypes
		//see clean code
		
	}
}
