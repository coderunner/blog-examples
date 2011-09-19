package org.mdd.examples.stateless;

public interface ProcessorContext
{   
    public void setAttribute(String key, Object value);
    
    public Object getAttribute(String key);
}
