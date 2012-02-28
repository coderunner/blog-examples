package org.mdd.examples.confoo.testable;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mdd.examples.confoo.testable.MessageSender.ConnectionFactory;
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
		
		messageSender = new MessageSender(connectionFactory, messageDatabase);
		
		Mockito.when(connectionFactory.createConnection()).thenReturn(connection);
		Mockito.when(messageDatabase.getMessage(Mockito.anyString())).thenReturn("test".getBytes());
	}
	
	@Test
	public void testAddConnection() throws IOException {
		
		String address = "address";
		messageSender.addConnection(address);
		Mockito.verify(connection).connect(address);
	}
	
	@Test
	public void testSendMessage() throws IOException {
		
		messageSender.addConnection("address"); //because MessageSender is stateful
		messageSender.sendMessage("key");
		Mockito.verify(connection).write(MESSAGE);
	}
	
	@Test
	public void testSendMessageException() throws IOException {
		
		Mockito.doThrow(new IOException()).when(connection).write(MESSAGE);
		messageSender.addConnection("address"); //because MessageSender is stateful
		try {
			messageSender.sendMessage("key");
			fail();
		} catch(IOException e) {
			//all great!
		}
	}
	
}
