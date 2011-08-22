package org.mdd.examples.nondeterministic;

public class CurrentTimeFormatter
{
	private static String FORMAT = "Current time in millis is : ";
	
	//Not testable since can not predict value of System.currentTimeMillis()
	public String formatCurrentTime_notTestable()
	{
		return FORMAT + System.currentTimeMillis();
	}
	
	//Can mock TimeAccessor in test code.
	public String formatCurrentTime(TimeAccessor aTimeAccessor)
	{
		return FORMAT + aTimeAccessor.getCurrentTime();
	}
	
	//Can override getCurrentTime in test code.
	public String formatCurrentTime()
	{
		
		return FORMAT + getCurrentTime();
	}
	
	long getCurrentTime()
	{
		return System.currentTimeMillis();
	}
}
