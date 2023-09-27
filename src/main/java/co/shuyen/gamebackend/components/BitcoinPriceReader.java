package co.shuyen.gamebackend.components;

import co.shuyen.gamebackend.interfaces.IPriceReader;
import org.springframework.stereotype.Component;

@Component
public class BitcoinPriceReader implements IPriceReader {
    @Override
    public double getPrice() {
        return 0;
    }
}
