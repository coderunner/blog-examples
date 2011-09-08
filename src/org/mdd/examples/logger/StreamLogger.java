package org.mdd.examples.logger;

import java.io.IOException;
import java.io.OutputStream;

public class StreamLogger extends Logger
{
    private final OutputStream stream;
    
    public StreamLogger(String name, OutputStream stream)
    {
        super(name);
        this.stream = stream;
    }

    @Override
    protected void log(String formattedLog)
    {
        try
        {
            stream.write(formattedLog.getBytes());
            stream.flush();
        }
        catch (IOException e)
        {
            throw new RuntimeException("Could not write on the stream.", e);
        }
    }
    
    public void close() throws IOException
    {
        stream.close();
    }
}
