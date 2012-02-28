package org.mdd.examples.confoo.testable;

import java.io.IOException;
import java.io.OutputStream;

public interface Connection {
	
	public void connect(String remoteAddress) throws IOException;
	public void write(byte[] message) throws IOException;
	public OutputStream getOutputStream();
	

}
