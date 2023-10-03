package co.shuyen.gamebackend.consumers;


// Importing required classes
import co.shuyen.gamebackend.components.BitcoinPriceReader;
import co.shuyen.gamebackend.interfaces.IPriceReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;

@Component

// Class
public class KafkaConsumer {
    private IPriceReader priceReader;
    @Autowired
    public KafkaConsumer(BitcoinPriceReader priceReader) {
        this.priceReader = priceReader;
    }
    // Method
    @KafkaListener(topics = "game-message", groupId = "group_id")
    public void
    consume(String message) throws URISyntaxException, IOException {
        // Print statement
        var price = priceReader.getPrice();
        System.out.println("message = " + price);
    }
}
