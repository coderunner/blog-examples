package org.mdd.examples.functional.object;

public class Main {
	
	public static void main(String[] args) {
		
		ImmutableEmployee e = new ImmutableEmployee("joe", 33, 55000, 0.05f);
		
		//easy way to represent, can lead to functions unrelated being together
		//just to be close to employee data
		//if state ok, if process...not sure it is the best
		int bonus = e.computeBonus(0.10f);
		int weekSalary = e.getWeeklySalary();
		boolean isEligible = e.isEligibleForBenefits();
	}

}
