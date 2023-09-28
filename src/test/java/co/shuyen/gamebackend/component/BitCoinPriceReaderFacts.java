package co.shuyen.gamebackend.component;
import co.shuyen.gamebackend.components.BitcoinPriceReader;
import co.shuyen.gamebackend.components.adapter.BitcoinPriceReaderAdapter;
import co.shuyen.gamebackend.interfaces.ports.in.IPriceRetriever;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BitCoinPriceReaderFacts {
    @Mock
    private IPriceRetriever priceRetriever;

    private BitcoinPriceReader yourClassUnderTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize annotated mocks
        yourClassUnderTest = new BitcoinPriceReader(priceRetriever); // Inject the mocked PriceRetriever
    }

    @Test
    void testGetPrice() throws URISyntaxException, IOException {
        // Mock the behavior of priceRetriever
        String jsonString = "{\"status\":{\"timestamp\":\"2023-09-28T18:32:58.563Z\",\"error_code\":0,\"error_message\":null,\"elapsed\":36,\"credit_count\":1,\"notice\":null},\"data\":[{\"id\":1,\"symbol\":\"BTC\",\"name\":\"Bitcoin\",\"amount\":10,\"last_updated\":\"2023-09-28T18:31:00.000Z\",\"quote\":{\"USD\":{\"price\":271368.05104521493,\"last_updated\":\"2023-09-28T18:31:00.000Z\"}}}]}";
        when(priceRetriever.makeAPICall()).thenReturn(jsonString);

        // Call the method you want to test
        double result = yourClassUnderTest.getPrice();

        // Verify that the makeAPICall method was called
        verify(priceRetriever, times(1)).makeAPICall();

        // Verify the expected result
        assertEquals(271368.05104521493, result);
    }
}
