package co.shuyen.gamebackend.interfaces.ports.in;

import java.io.IOException;
import java.net.URISyntaxException;

public interface IPriceRetriever {
    String makeAPICall()
            throws URISyntaxException, IOException;
}
