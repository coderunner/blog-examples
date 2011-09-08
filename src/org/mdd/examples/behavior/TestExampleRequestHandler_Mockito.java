package org.mdd.examples.behavior;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestExampleRequestHandler_Mockito
{
    private static final String STORE_BODY = "stored body";
    private static final String CASE_HEADER = "case";
    private static final String CASE_HEADER_VALUE = "uppercase";
    private static final String REQUEST_PATH = "path";
    
    private ExampleRequestHandler requestHandler;
    private HttpRequest request;
    private Context context;
    private Monitoring monitoring;
    private Store store;
    private Map<String, String> headers;
    
    @Before
    public void setup()
    {
        requestHandler = new ExampleRequestHandler();
        request = mock(HttpRequest.class);
        context = mock(Context.class);
        monitoring = mock(Monitoring.class);
        store = mock(Store.class);
        headers = mock(Map.class);
        
        when(context.getMonitoring()).thenReturn(monitoring);
        when(context.getStore()).thenReturn(store);
        when(store.get(REQUEST_PATH)).thenReturn(STORE_BODY);
        when(request.getPath()).thenReturn(REQUEST_PATH);
        when(request.getHeaders()).thenReturn(headers);
    }
    
    @Test 
    public void shouldReturnTheStoredBody()
    {
        HttpResponse response = requestHandler.handle(request, context);
        assertEquals(STORE_BODY, response.getBody());
    }
    
    @Test 
    public void responseCodeShouldBe200()
    {
        HttpResponse response = requestHandler.handle(request, context);
        assertEquals(200, response.getCode());
    }
    
    @Test 
    public void shouldIncrementRequestCounter()
    {
        requestHandler.handle(request, context);
        verify(monitoring).incrementRequestCounter();
    }
    
    @Test 
    public void shouldConvertToUpperCaseIfHeaderValuePresent()
    {
        when(headers.get(CASE_HEADER)).thenReturn(CASE_HEADER_VALUE);
        
        HttpResponse response = requestHandler.handle(request, context);
        assertEquals(STORE_BODY.toUpperCase(), response.getBody());
    }
}
