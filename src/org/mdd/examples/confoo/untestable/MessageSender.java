package org.mdd.examples.confoo.untestable;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;



public class MessageSender {
	
	private final List<Socket> sockets = new ArrayList<Socket>();
	
	public void addConnection(SocketAddress remote) throws IOException {
		Socket s = new Socket();
		s.connect(remote);
		sockets.add(s);
	}
	
	public void sendMessage(String messageKey) throws IOException {
		byte[] message = MessageDatabase.getMessage(messageKey);
		for(Socket s : sockets) {
			s.getOutputStream().write(message);
			s.getOutputStream().flush();
		}
	}
}
