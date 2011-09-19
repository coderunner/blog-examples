package org.mdd.examples.stateless;

public class StatelessBodyTransformer implements StatelessProcessor
{
    private static final String BODY_TRANSFORM = "transform";
    
    @Override
    public void processRequest(HttpRequest request, ProcessorContext context)
    {
        String transformValue = request.getHeaders().get(BODY_TRANSFORM);
        if(transformValue == null)
        {
            context.setAttribute(BODY_TRANSFORM, Transform.NONE);
        }
        else
        {
            context.setAttribute(BODY_TRANSFORM, Transform.valueOf(transformValue));
        }
    }

    @Override
    public void processResponse(HttpResponse response, ProcessorContext context)
    {
        Transform transform = (Transform) context.getAttribute(BODY_TRANSFORM);

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
