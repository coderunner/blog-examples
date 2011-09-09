package org.mdd.examples.logger;

public class NetworkLogger extends Logger
{
    private final int max_length;
    private final Connection connection;
    
    public NetworkLogger(String name, Connection connection, int max_length)
    {
        super(name);
        this.max_length = max_length;
        this.connection = connection;
    }
    
    @Override
    protected String formatLog(Level level, String message)
    {
        String formattedLog = super.formatLog(level, message);
        if(formattedLog.length() > max_length)
        {
            return formattedLog.substring(0, max_length);
        }
        return formattedLog;
        
    }

    @Override
    protected void log(String formattedLog)
    {
        connection.send(formattedLog);
    }
}
