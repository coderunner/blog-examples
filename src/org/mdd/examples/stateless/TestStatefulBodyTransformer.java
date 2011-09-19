package org.mdd.examples.stateless;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TestStatefulBodyTransformer
{
    private static final String TRANSFORM_HEADER = "transform";
    private static final String BODY = "desserts";
    
    private StatefulBodyTransformer transformer;
    private HttpRequest request;
    private Map headers;
    private HttpResponse response;
    
    @Before
    public void setup()
    {
        transformer = new StatefulBodyTransformer();
        request = mock(HttpRequest.class);
        headers = mock(Map.class);
        response = mock(HttpResponse.class);
        
        when(request.getHeaders()).thenReturn(headers);
        when(response.getBody()).thenReturn(BODY);
    }
    
    @Test
    public void shouldNotTransformIfNoValue()
    {
        transformer.processRequest(request);
        transformer.processResponse(response);
        verifyZeroInteractions(response);
    }
    
    @Test
    public void shouldNotTransformIfNone()
    {
        when(headers.get(TRANSFORM_HEADER)).thenReturn("NONE");
        transformer.processRequest(request);
        transformer.processResponse(response);
        verifyZeroInteractions(response);
    }
    
    @Test
    public void shouldReverse()
    {
        when(headers.get(TRANSFORM_HEADER)).thenReturn("REVERSE");
        transformer.processRequest(request);
        transformer.processResponse(response);
        verify(response).setBody(new StringBuffer(BODY).reverse().toString());
    }
     
    @Test
    public void shouldUpperCase()
    {
        when(headers.get(TRANSFORM_HEADER)).thenReturn("UPPERCASE");
        transformer.processRequest(request);
        transformer.processResponse(response);
        verify(response).setBody(BODY.toUpperCase());
    }
}