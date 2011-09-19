package org.mdd.examples.stateless;

public class StatefulBodyTransformer implements StatefulProcessor
{
    private static final String BODY_TRANSFORM = "transform";
    
    private Transform transform;
    
    @Override
    public void processRequest(HttpRequest request)
    {
        String transformValue = request.getHeaders().get(BODY_TRANSFORM);
        if(transformValue == null)
        {
            transform = Transform.NONE;
        }
        else
        {
            transform = Transform.valueOf(transformValue);
        }
    }

    @Override
    public void processResponse(HttpResponse response)
    {
        switch (transform)
        {
        case REVERSE:
            response.setBody(new StringBuffer(response.getBody()).reverse().toString());
            break;
        case UPPERCASE:
            response.setBody(response.getBody().toUpperCase());
        case NONE:
        default:
            break;
        }
    }
}
