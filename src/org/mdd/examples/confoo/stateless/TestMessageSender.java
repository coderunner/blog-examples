package org.mdd.examples.confoo.stateless;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mdd.examples.confoo.stateless.MessageSender.ConnectionFactory;
import org.mdd.examples.confoo.testable.Connection;
import org.mdd.examples.confoo.testable.MessageDatabase;
import org.mockito.Mockito;

public class TestMessageSender {
	
	private static byte[] MESSAGE = "test".getBytes();
	
	private ConnectionFactory connectionFactory;
	private Connection connection;
	private MessageDatabase messageDatabase;
	private MessageSender messageSender;
	
	@Before
	public void setup() throws Exception {
		
		connectionFactory = Mockito.mock(ConnectionFactory.class);
		connection = Mockito.mock(Connection.class);
		messageDatabase = Mockito.mock(MessageDatabase.class);
		
		Mockito.when(connectionFactory.createConnection()).thenReturn(connection);
		Mockito.when(messageDatabase.getMessage(Mockito.anyString())).thenReturn("test".getBytes());
		
		messageSender = new MessageSender(connectionFactory, messageDatabase, new String[] {"address"});
		Mockito.reset(connection);
	}
	
	@Test
	public void testConstruction() throws IOException {
		
		String address = "address";
		messageSender = new MessageSender(connectionFactory, messageDatabase, new String[] {address});
		Mockito.verify(connection).connect(address);
	}
	
	@Test
	public void testSendMessage() throws IOException {
		
		messageSender.sendMessage("key");
		Mockito.verify(connection).write(MESSAGE);
	}
	
	@Test
	public void testSendMessageException() throws IOException {
		
		Mockito.doThrow(new IOException()).when(connection).write(MESSAGE);
		try {
			messageSender.sendMessage("key");
			fail();
		} catch(IOException e) {
			//all great!
		}
	}
}