package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class MyServiceTest {

    @Test
    void testVerifyInteraction() {
        // Create a mock object for the external API dependency.
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Inject the mock into the service under test.
        MyService service = new MyService(mockApi);

        // Call the method under test.
        service.fetchData();

        // Verify that the interaction occurred exactly once.
        verify(mockApi).getData();
    }
}
