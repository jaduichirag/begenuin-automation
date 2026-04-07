package tests;

import base.BaseTest;
import pages.GenAiPage;
import utils.Config;
import utils.NetworkUtils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GenAiDevToolsTest extends BaseTest {

    @Test
    public void TC01_verifyChatAPIResponseUsingDevTools() {

        // Start listening
        NetworkUtils.startListening(devTools);

        driver.get(Config.GenaiURL);

        GenAiPage page = new GenAiPage(driver, wait);

        // Send message
        page.enterMessage("What is AI?");
        page.clickSend();

        // Wait for response
        page.waitForResponse();

        // UI validation
        String uiResponse = page.getResponseText();
        Assert.assertFalse(uiResponse.isEmpty());

        // API validation (captured)
        String apiResponse = NetworkUtils.capturedResponse;

        System.out.println("📦 API Response: " + apiResponse);

        Assert.assertNotNull(apiResponse);
        Assert.assertFalse(apiResponse.isEmpty());
    }
}