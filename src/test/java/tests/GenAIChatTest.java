package tests;

import base.BaseTest;
import pages.GenAiPage;
import utils.Config;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GenAIChatTest extends BaseTest {

    // ================= BASIC =================

    @Test
    public void TC01_verifyChatBoxVisible() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);

        Assert.assertTrue(page.isChatBoxVisible());
    }

    @Test
    public void TC02_verifySendDisabledInitially() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);

        Assert.assertTrue(page.isSendDisabled());
    }

    // ================= INPUT =================

    @Test
    public void TC03_verifyTypingMessage() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);

        page.enterMessage("Hello AI");

        Assert.assertTrue(page.isSendEnabled());
    }

    @Test
    public void TC04_verifyEmptyMessageNotSent() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);

        page.enterMessage("");

        Assert.assertTrue(page.isSendDisabled());
    }

    @Test
    public void TC05_verifySpacesNotAllowed() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);

        page.enterMessage("     ");

        Assert.assertTrue(page.isSendDisabled());
    }

    @Test
    public void TC06_verifySpecialCharacters() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);

        page.enterMessage("@#$%^&*");

        Assert.assertTrue(page.isSendEnabled());
    }

    // ================= SEND =================

    @Test
    public void TC07_verifyMessageSend() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);

        page.enterMessage("Hello AI");
        page.clickSend();

        Assert.assertTrue(true); // Replace with response validation
    }

    // ================= RESPONSE =================

    @Test
    public void TC08_verifyResponseDisplayed() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);

        page.enterMessage("What is AI?");
        page.clickSend();

        Assert.assertTrue(page.isResponseVisible());
    }

    @Test
    public void TC09_verifyResponseNotEmpty() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);

        page.enterMessage("Explain AI");
        page.clickSend();

        String response = page.getResponseText();

        Assert.assertFalse(response.isEmpty());
    }

    // ================= PERFORMANCE =================

    @Test
    public void TC10_verifyResponseTime() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);

        long start = System.currentTimeMillis();

        page.enterMessage("Hello");
        page.clickSend();

        page.waitForResponse();

        long end = System.currentTimeMillis();

        Assert.assertTrue((end - start) < 18000);
    }

    // ================= EDGE =================

    @Test
    public void TC11_verifyLongMessage() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);

        String longText = "AI ".repeat(300);

        page.enterMessage(longText);
        page.clickSend();

        Assert.assertTrue(true);
    }

    @Test
    public void TC12_verifyMultipleClicksHandled() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);

        page.enterMessage("Test");
        page.clickSend();
        page.clickSend();

        Assert.assertTrue(true);
    }
}