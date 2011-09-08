package org.mdd.examples.logger;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.OutputStream;

import org.junit.Before;
import org.junit.Test;
import org.mdd.examples.logger.Logger.Level;
import org.mockito.Mockito;

public class TestStreamLogger
{
    private static final String LOGGER_NAME = "logger_name";
    private static final Logger.Level LEVEL = Level.INFO;
    private static final String MESSAGE = "message";
    private StreamLogger logger;
    private OutputStream stream;
    
    @Before
    public void setup()
    {
        stream = Mockito.mock(OutputStream.class);
        logger = new StreamLogger("logger_name", stream);
    }
    
    @Test
    public void shouldWriteFormattedMesssageToStream() throws IOException
    {
        byte[] expectedStream = (
                LOGGER_NAME +" - " + LEVEL.toString() + " : " + MESSAGE).getBytes();
        
        logger.log(Level.INFO, MESSAGE);
        
        Mockito.verify(stream).write(expectedStream);
    }

    @Test
    public void shouldWriteToStream() throws IOException
    {
        logger.log(MESSAGE);
        
        Mockito.verify(stream).write(MESSAGE.getBytes());
    }
    
    @Test
    public void shouldIncrementLogCounter()
    {
        assertEquals(0, logger.getLogCount());
        logger.log(Level.INFO, MESSAGE);
        assertEquals(1, logger.getLogCount());
    }
}
