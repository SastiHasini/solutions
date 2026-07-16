package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MyServiceTest {

    @Test
    void testExternalApi() {
        // Create a mock object for the external API.
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Stub the method to return a predefined value.
        when(mockApi.getData()).thenReturn("Mock Data");

        // Inject the mock into the service.
        MyService service = new MyService(mockApi);

        // Call the method under test.
        String result = service.fetchData();

        // Assert the returned data matches the stubbed value.
        assertEquals("Mock Data", result);
    }
}
