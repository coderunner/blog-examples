package org.mdd.examples.behavior;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TestRequestHandler_EasyMock
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
        request = createMock(HttpRequest.class);
        context = createMock(Context.class);
        monitoring = createMock(Monitoring.class);
        store = createMock(Store.class);
        headers = createMock(Map.class);
    }
    
    @Test
    public void shouldReturnedAnUpperCaseVersionOfStoredText()
    {
        //record mode
        //record behavior and expected calls
        reset(request, context, monitoring, store, headers);
        expect(context.getMonitoring()).andReturn(monitoring);
        monitoring.incrementRequestCounter();
        expect(request.getPath()).andReturn(REQUEST_PATH);
        expect(request.getHeaders()).andReturn(headers);
        expect(headers.get(CASE_HEADER)).andReturn(CASE_HEADER_VALUE);
        expect(context.getStore()).andReturn(store);
        expect(store.get(REQUEST_PATH)).andReturn(STORE_BODY);
        
        //enter replay mode
        replay(request, context, monitoring, store, headers);
        
        //test call
        HttpResponse response = requestHandler.handle(request, context);
        
        //assertions
        assertEquals(STORE_BODY.toUpperCase(), response.getBody());
        assertEquals(200, response.getCode());
        
        //verify mocks
        verify(request, context, monitoring, store, headers);
    }
    
    @Test
    public void shouldReturnedStoredText()
    {
        //record mode
        //record behavior and expected calls
        reset(request, context, monitoring, store, headers);
        expect(context.getMonitoring()).andReturn(monitoring);
        monitoring.incrementRequestCounter();
        expect(request.getPath()).andReturn(REQUEST_PATH).anyTimes();
        expect(request.getHeaders()).andReturn(headers);
        expect(headers.get(CASE_HEADER)).andReturn("Other Value");
        expect(context.getStore()).andReturn(store);
        expect(store.get(REQUEST_PATH)).andReturn(STORE_BODY);
        
        //enter replay mode
        replay(request, context, monitoring, store, headers);
        
        //test call
        HttpResponse response = requestHandler.handle(request, context);
        
        //assertions
        assertEquals(STORE_BODY, response.getBody());
        assertEquals(200, response.getCode());
        
        //verify mocks
        verify(request, context, monitoring, store, headers);
    }
}
