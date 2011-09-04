package org.mdd.examples.behavior;

public class ExampleRequestHandler implements RequestHandler
{
    @Override
    public HttpResponse handle(HttpRequest request, Context context)
    {
        context.getMonitoring().incrementRequestCounter();
        
        String storeKey = request.getPath();
        String result =  context.getStore().get(storeKey);
        
        String caseHeaderValue = request.getHeaders().get("case");
        if(caseHeaderValue.equals("uppercase"))
        {
            result = result.toUpperCase();
        }

        return new HttpResponse(200, result);
    }

}
