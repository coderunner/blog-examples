package org.mdd.examples.logger;

public abstract class Logger
{
    public static enum Level
    {
        INFO,
        WARNING,
        FATAL
    };
    
    private String name;
    private int logCount = 0;
    
    public Logger(String name)
    {
        this.name = name;
    }
    
    public void log(Level level, String message)
    {
        String formattedLog = formatLog(level, message);
        log(formattedLog);
        ++logCount;
    }
    
    public int getLogCount()
    {
        return logCount;
    }
    
    protected abstract void log(String formattedLog);
    
    private String formatLog(Level level, String message)
    {
        String formattedLog = name + " - "+ level.toString()+" : "+message;
        return formattedLog;
    }
}
