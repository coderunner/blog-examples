package org.mdd.examples.logger;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TestLogger
{
    private static final String LOGGER_NAME = "logger_name";
    private static final Level LEVEL = Level.INFO;
    private static final String MESSAGE = "message";
    private static final String FORMATTED_LOG = LOGGER_NAME + " - " + LEVEL + " : " + MESSAGE;
    
    private Logger logger;
    
    @Before
    public void setup()
    {
        logger = spy(new Logger(LOGGER_NAME)
        {
            @Override
            protected void log(String formattedLog)
            {}
        });
        
        //mock abstract method
        doNothing().when(logger).log(anyString());
    }
    
    @Test
    public void shouldFormatAndLog()
    {
        logger.log(LEVEL, MESSAGE);
        verify(logger).log(FORMATTED_LOG);
    }
    
    @Test
    public void shouldFormatMessage()
    {
        String formattedMessage = logger.formatLog(LEVEL, MESSAGE);
        assertEquals(FORMATTED_LOG, formattedMessage);
    }
    
    @Test
    public void shouldIncrementLogCounter()
    {
        assertEquals(0, logger.getLogCount());
        logger.log(LEVEL, MESSAGE);
        assertEquals(1, logger.getLogCount());
    }
}
