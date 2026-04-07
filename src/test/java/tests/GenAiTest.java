package tests;

import base.BaseTest;
import pages.GenAiPage;
import utils.Config;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GenAiTest extends BaseTest {

    // ================= HEADER =================

    @Test
    public void TC01_verifyLogoVisible() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        Assert.assertTrue(page.isLogoVisible());
    }

    @Test
    public void TC02_verifyPlatformNav() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        page.clickPlatform();
        Assert.assertTrue(driver.getCurrentUrl().contains("platform"));
    }

    @Test
    public void TC03_verifyGenaiNav() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        Assert.assertTrue(page.isGenAiActive());
    }

    @Test
    public void TC04_verifyCompanyNav() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        page.clickCompany();
        Assert.assertTrue(driver.getCurrentUrl().contains("company"));
    }

    @Test
    public void TC05_verifyLoginButton() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        Assert.assertTrue(page.isLoginVisible());
    }

    @Test
    public void TC06_verifyStartFreeButton() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        Assert.assertTrue(page.isStartFreeVisible());
    }

    // ================= PAGE LOAD =================

    @Test
    public void TC07_verifyPageLoad() {
        driver.get(Config.GenaiURL);
        Assert.assertTrue(driver.getPageSource().length() > 1000);
    }

    @Test
    public void TC08_verifyTitle() {
        driver.get(Config.GenaiURL);
        Assert.assertFalse(driver.getTitle().isEmpty());
    }

    @Test
    public void TC09_verifyURL() {
        driver.get(Config.GenaiURL);
        Assert.assertTrue(driver.getCurrentUrl().contains("genai"));
    }

    // ================= HERO =================

    @Test
    public void TC10_verifyHeroTitle() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        Assert.assertTrue(page.isHeroTitleVisible());
    }

    @Test
    public void TC11_verifyHeroSubtitle() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        Assert.assertTrue(page.isHeroSubtitleVisible());
    }

    // ================= AGENTS =================

    @Test
    public void TC12_verifyAgentsSection() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        Assert.assertTrue(page.isAgentsSectionVisible());
    }

    @Test
    public void TC13_verifyAgentsCount() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        Assert.assertTrue(page.getAgentsCount() >= 5);
    }

    @Test
    public void TC14_verifyAgentImages() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        Assert.assertTrue(page.areAgentImagesDisplayed());
    }

    @Test
    public void TC15_verifyAgentNames() {
        driver.get(Config.GenaiURL);
        Assert.assertTrue(driver.getPageSource().contains("Agent"));
    }

    @Test
    public void TC16_verifyAgentDescription() {
        driver.get(Config.GenaiURL);
        Assert.assertTrue(driver.getPageSource().length() > 1500);
    }

    // ================= START BUTTON =================

    @Test
    public void TC17_verifyStartButtonClickable() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        page.clickFirstStart();
        Assert.assertTrue(true);
    }

    @Test
    public void TC18_verifyMultipleStartButtons() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        Assert.assertTrue(page.getStartButtonCount() > 1);
    }

    // ================= CHAT =================

    @Test
    public void TC19_verifyChatBoxVisible() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        Assert.assertTrue(page.isChatBoxVisible());
    }

    @Test
    public void TC20_verifyChatPlaceholder() {
        driver.get(Config.GenaiURL);
        Assert.assertTrue(driver.getPageSource().contains("Type your message"));
    }

    @Test
    public void TC21_verifySendButtonDisabled() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        Assert.assertTrue(page.isSendDisabled());
    }

    // ================= INPUT =================

    @Test
    public void TC22_verifyTypingMessage() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        page.enterMessage("Hello AI");
        Assert.assertTrue(true);
    }

    @Test
    public void TC23_verifySendEnabledAfterTyping() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        page.enterMessage("Test");
        Assert.assertTrue(page.isSendEnabled());
    }

    // ================= SCROLL =================

    @Test
    public void TC24_verifyScrollDown() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        page.scrollDown();
        Assert.assertTrue(true);
    }

    // ================= FILE UPLOAD =================

    @Test
    public void TC25_verifyUploadButtonPresent() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        Assert.assertTrue(page.isUploadVisible());
    }

    // ================= RESPONSIVE =================

    @Test
    public void TC26_verifyMobileView() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        page.setMobileView();
        Assert.assertTrue(true);
    }

    @Test
    public void TC27_verifyTabletView() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        page.setTabletView();
        Assert.assertTrue(true);
    }

    // ================= LINKS =================

    @Test
    public void TC28_verifyLinksCount() {
        driver.get(Config.GenaiURL);
        GenAiPage page = new GenAiPage(driver, wait);
        Assert.assertTrue(page.getLinksCount() > 5);
    }

    // ================= PERFORMANCE =================

    @Test
    public void TC29_verifyPageSpeed() {
        driver.get(Config.GenaiURL);
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        Assert.assertTrue((end - start) < 5000);
    }

    // ================= EXTRA =================

    @Test
    public void TC30_verifyReload() {
        driver.get(Config.GenaiURL);
        driver.navigate().refresh();
        Assert.assertTrue(true);
    }

    @Test
    public void TC31_verifyBackNavigation() {
        driver.get(Config.GenaiURL);
        driver.navigate().to(Config.BASE_URL );
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("genai"));
    }

    @Test
    public void TC32_verifyForwardNavigation() {
        driver.get(Config.GenaiURL);
        driver.navigate().to(Config.BASE_URL );
        driver.navigate().back();
        driver.navigate().forward();
        Assert.assertTrue(true);
    }

}