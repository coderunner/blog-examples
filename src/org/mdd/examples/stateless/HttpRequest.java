package org.mdd.examples.stateless;

import java.util.Map;

public interface HttpRequest
{
    public String getPath();
    public Map<String, String> getHeaders();
    public String getBody();
}
