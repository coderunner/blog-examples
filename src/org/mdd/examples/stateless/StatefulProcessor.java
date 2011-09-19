package org.mdd.examples.stateless;

public interface StatefulProcessor
{
    public void processRequest(HttpRequest request);
    
    public void processResponse(HttpResponse response);
}
