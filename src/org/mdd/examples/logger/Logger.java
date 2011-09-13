package org.mdd.examples.logger;

public abstract class Logger
{
    private final String name;
    private int logCount = 0;
    
    public Logger(String name)
    {
        this.name = name;
    }
    
    public int getLogCount()
    {
        return logCount;
    }
    
    public void log(Level level, String message)
    {
        log(formatLog(level, message));
        ++logCount;
    }
    
    protected String formatLog(Level level, String message)
    {
        return name + " - "+ level +" : "+message;
    }
    
    protected abstract void log(String formattedLog);
}
