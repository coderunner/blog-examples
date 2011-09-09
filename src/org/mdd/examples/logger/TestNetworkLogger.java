package org.mdd.examples.logger;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TestNetworkLogger
{
    private static final int MAX_LENGTH = 30;
    private static final String LOGGER_NAME = "logger_name";
    private static final Level LEVEL = Level.INFO;
    private static final String MESSAGE = "long message, very long message";
    
    private NetworkLogger logger;
    private Connection connection;
    
    @Before
    public void setup()
    {
        connection = mock(Connection.class);
        logger = new NetworkLogger(LOGGER_NAME, connection, MAX_LENGTH);
    }
    
    @Test
    public void shouldSendTruncatedMessageOnConnection()
    {
        logger.log(LEVEL, MESSAGE);
        verify(connection).send((LOGGER_NAME + " - " + LEVEL + " : " + MESSAGE).substring(0, MAX_LENGTH));
    }
}
