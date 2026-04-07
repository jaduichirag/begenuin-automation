package utils;

import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v124.network.Network;

import java.util.Optional;

public class NetworkUtils {

    public static String capturedResponse = "";

    public static void startListening(DevTools devTools) {

        devTools.addListener(Network.responseReceived(), response -> {

            String url = response.getResponse().getUrl();

            if (url.contains("genai")) {  // filter your API

                System.out.println("API HIT(Api url is): " + url);

                try {
                    devTools.send(Network.getResponseBody(response.getRequestId()))
                            .getBody();

                    capturedResponse = devTools.send(
                            Network.getResponseBody(response.getRequestId())
                    ).getBody();

                } catch (Exception e) {
                    System.out.println("Error capturing response");
                }
            }
        });
    }
}