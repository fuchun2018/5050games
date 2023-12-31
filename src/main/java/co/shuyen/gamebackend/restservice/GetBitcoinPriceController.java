package co.shuyen.gamebackend.restservice;

import co.shuyen.gamebackend.components.BitcoinPriceReader;
import co.shuyen.gamebackend.interfaces.IPriceReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetBitcoinPriceController {
    private final IPriceReader priceReader;

    @Autowired
    public GetBitcoinPriceController(BitcoinPriceReader priceReader) {
        this.priceReader = priceReader;
    }
    @GetMapping("/getPrice")
    public double getPrice() {
        return priceReader.getPrice();
    }
}
