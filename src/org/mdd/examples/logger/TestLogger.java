package org.mdd.examples.logger;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mdd.examples.logger.Logger.Level;
import org.mockito.Mockito;

public class TestLogger
{
    private static final String LOGGER_NAME = "logger_name";
    private static final Logger.Level LEVEL = Level.INFO;
    private static final String MESSAGE = "message";
    private Logger logger;
    
    @Before
    public void setup()
    {
        Logger l = new Logger(LOGGER_NAME)
        {
            @Override
            protected void log(String formattedLog)
            {}
        };
        logger = Mockito.spy(l);
        Mockito.doNothing().when(logger).log(Mockito.anyString());
    }
    
    @Test
    public void shouldFormatAndLog()
    {
        logger.log(LEVEL, MESSAGE);
        
        Mockito.verify(logger).log(LOGGER_NAME + " - " + LEVEL + " : " + MESSAGE);
        
    }
    
    @Test
    public void shouldIncrementLogCounter()
    {
        assertEquals(0, logger.getLogCount());
        logger.log(LEVEL, MESSAGE);
        assertEquals(1, logger.getLogCount());
    }

}
