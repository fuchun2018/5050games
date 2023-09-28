package co.shuyen.gamebackend.interfaces;

import java.io.IOException;
import java.net.URISyntaxException;

public interface IPriceReader {
     double getPrice() throws URISyntaxException, IOException;
}
