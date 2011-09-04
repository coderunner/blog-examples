package org.mdd.examples.behavior;

import java.util.Map;

public interface HttpRequest
{
    public String getPath();
    public Map<String, String> getHeaders();
}
