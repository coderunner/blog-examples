package org.mdd.examples.logger;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.OutputStream;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TestStreamLogger
{
    private static final String LOGGER_NAME = "logger_name";
    private static final Level LEVEL = Level.INFO;
    private static final String MESSAGE = "message";
    private StreamLogger logger;
    private OutputStream stream;
    
    @Before
    public void setup()
    {
        stream = mock(OutputStream.class);
        logger = new StreamLogger(LOGGER_NAME, stream);
    }
    
    @Test
    public void shouldWriteFormattedMesssageToStream() throws Exception
    {
        logger.log(Level.INFO, MESSAGE);
        verify(stream).write((LOGGER_NAME +" - " + LEVEL + " : " + MESSAGE).getBytes());
    }
    
    @Test
    public void shouldCloseStream() throws Exception
    {
        logger.close();
        verify(stream).close();
    }
}
