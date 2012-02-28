package org.mdd.examples.confoo.testable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;;


public class MessageSender {

	private final List<Connection> connections = new ArrayList<Connection>();
	private final ConnectionFactory connectionFactory;
	private final MessageDatabase messageDatabase;
	
	public MessageSender(ConnectionFactory connectionFactory,
			MessageDatabase messageDatabase) {
		
		this.connectionFactory = connectionFactory;
		this.messageDatabase = messageDatabase;
	}
	
	public void addConnection(String remoteAddress) throws IOException {
		
		Connection c = connectionFactory.createConnection();
		c.connect(remoteAddress);
		connections.add(c);
	}
	
	public void sendMessage(String messageKey) throws IOException {
		
		byte[] message = messageDatabase.getMessage(messageKey);
		for(Connection c : connections) {
			c.write(message);
		}
	}
	
	public interface ConnectionFactory {
		
		public Connection createConnection();
	}
}
