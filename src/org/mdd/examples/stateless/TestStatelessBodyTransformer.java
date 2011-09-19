package org.mdd.examples.stateless;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class TestStatelessBodyTransformer
{
    private static final String TRANSFORM_HEADER = "transform";
    private static final String BODY = "desserts";
    
    private StatelessBodyTransformer transformer;
    private HttpRequest request;
    private Map headers;
    private HttpResponse response;
    private ProcessorContext context;
    
    @Before
    public void setup()
    {
        transformer = new StatelessBodyTransformer();
        request = mock(HttpRequest.class);
        headers = mock(Map.class);
        response = mock(HttpResponse.class);
        context = mock(ProcessorContext.class);
        
        when(request.getHeaders()).thenReturn(headers);
        when(response.getBody()).thenReturn(BODY);
    }
    
    @Test
    public void shouldStoreNoneInContextIfNoHeader()
    {
        transformer.processRequest(request, context);
        verify(context).setAttribute(TRANSFORM_HEADER, Transform.NONE);
    }
    
    @Test
    public void shouldStoreReverseInContext()
    {
        when(headers.get(TRANSFORM_HEADER)).thenReturn("REVERSE");
        transformer.processRequest(request, context);
        verify(context).setAttribute(TRANSFORM_HEADER, Transform.REVERSE);
    }
    
    @Test
    public void shouldStoreUpperCaseInContext()
    {
        when(headers.get(TRANSFORM_HEADER)).thenReturn("UPPERCASE");
        transformer.processRequest(request, context);
        verify(context).setAttribute(TRANSFORM_HEADER, Transform.UPPERCASE);
    }
    
    @Test
    public void shouldNotTransformIfNone()
    {
        when(context.getAttribute(TRANSFORM_HEADER)).thenReturn(Transform.NONE);
        transformer.processResponse(response, context);
        Mockito.verifyZeroInteractions(response);
    }
    
    @Test
    public void shouldReverse()
    {
        when(context.getAttribute(TRANSFORM_HEADER)).thenReturn(Transform.REVERSE);
        transformer.processResponse(response, context);
        verify(response).setBody(new StringBuffer(BODY).reverse().toString());
    }
     
    @Test
    public void shouldUpperCase()
    {
        when(context.getAttribute(TRANSFORM_HEADER)).thenReturn(Transform.UPPERCASE);
        transformer.processResponse(response, context);
        verify(response).setBody(BODY.toUpperCase());
    }
}
