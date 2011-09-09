package org.mdd.examples.logger;

public abstract class Logger
{
    private String name;
    private int logCount;
    
    public Logger(String name)
    {
        this.name = name;
        logCount = 0;
    }
    
    public void log(Level level, String message)
    {
        log(formatLog(level, message));
        ++logCount;
    }
    
    public int getLogCount()
    {
        return logCount;
    }
    
    protected String formatLog(Level level, String message)
    {
        return name + " - "+ level +" : "+message;
    }
    
    protected abstract void log(String formattedLog);
}
