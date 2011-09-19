package org.mdd.examples.stateless;

public interface StatelessProcessor
{
    public void processRequest(HttpRequest request, ProcessorContext context);
    
    public void processResponse(HttpResponse response, ProcessorContext context);
}
