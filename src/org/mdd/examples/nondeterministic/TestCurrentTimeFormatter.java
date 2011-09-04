package org.mdd.examples.nondeterministic;

import static org.junit.Assert.* ;

import org.junit.Test;
import org.testobject.Recorder;
import org.testobject.TestObject;

public class TestCurrentTimeFormatter
{
	private static final long CURRENT_TIME = 1000l;
	
	@Test
	public void testWithTestObject()
	{
		//Use mock or test object
		//Here a test object is used since we don't care if a call to time
		//accessor is made as long as the output string is all right.
		TimeAccessor accessor = TestObject.createTestObject(TimeAccessor.class);
		Recorder<TimeAccessor> accessorRecorder =
			TestObject.createRecorder(accessor);
		accessorRecorder.record(accessor.getCurrentTime()).andReturn(CURRENT_TIME);
		
		CurrentTimeFormatter formatter = new CurrentTimeFormatter();
		
		assertEquals("Current time in millis is : "+CURRENT_TIME,
				formatter.formatCurrentTime(accessor));	
	}
	
	@Test
	public void testWithPackagePrivateMethod()
	{
		//override non deterministic call
		CurrentTimeFormatter formatter = new CurrentTimeFormatter()
		{
			long getCurrentTime()
			{
				return CURRENT_TIME;
			}
		};
				
		assertEquals("Current time in millis is : "+CURRENT_TIME,
				formatter.formatCurrentTime());	
	}
}
