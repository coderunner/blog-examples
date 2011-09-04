package org.mdd.examples.behavior;

public interface RequestHandler
{
    public HttpResponse handle(HttpRequest request, Context context);
}
