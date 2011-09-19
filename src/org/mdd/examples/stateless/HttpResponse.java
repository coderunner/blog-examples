package org.mdd.examples.stateless;

public interface HttpResponse
{
    public int getResponseCode();
    public void setResponseCode(int code);
    public String getBody();
    public void setBody(String body);
}
