package co.shuyen.gamebackend.components;

import co.shuyen.gamebackend.interfaces.IPriceReader;
import co.shuyen.gamebackend.interfaces.ports.in.IPriceRetriever;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class BitcoinPriceReader implements IPriceReader {
    @Autowired
    private final IPriceRetriever priceRetriever;

    public BitcoinPriceReader(IPriceRetriever priceRetriever) {
        this.priceRetriever = priceRetriever;
    }
    @Override
    public double getPrice() throws URISyntaxException, IOException {
        var jsonString = priceRetriever.makeAPICall();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonString);
        JsonNode usdNode = rootNode.at("/data/0/quote/USD");
        double usdPrice = usdNode.has("price") ? usdNode.get("price").asDouble() : 0.0;
        LocalDateTime lastUpdated = usdNode.has("last_updated") ?
                LocalDateTime.parse(usdNode.get("last_updated").asText(), DateTimeFormatter.ISO_DATE_TIME) :
                LocalDateTime.MIN;

        return usdPrice;
    }
}
