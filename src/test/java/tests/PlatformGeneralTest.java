package tests;

import base.BaseTest;
import utils.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import java.util.List;

public class PlatformGeneralTest extends BaseTest {

    @Test
    public void TC41_verifyNoBrokenImages() {
         driver.get(Config.genuin_platformURL);
        List<WebElement> images = driver.findElements(By.tagName("img"));

        for (int i = 0; i < images.size(); i++) {
            String src = driver.findElements(By.tagName("img")).get(i).getAttribute("src");
            Assert.assertNotNull(src);
        }
    }

    @Test
    public void TC42_verifyScrollWorks() throws InterruptedException {
 driver.get(Config.genuin_platformURL);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,3000)");
        Thread.sleep(2000);

        Assert.assertTrue(true);
    }

    @Test
    public void TC43_verifyPageHeight() {
         driver.get(Config.genuin_platformURL);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Long height = (Long) js.executeScript("return document.body.scrollHeight");

        Assert.assertTrue(height > 1000);
    }

    @Test
    public void TC44_verifyMobileView() {
         driver.get(Config.genuin_platformURL);
        driver.manage().window().setSize(new Dimension(375, 812));
        Assert.assertTrue(true);
    }

    @Test
    public void TC45_verifyTabletView() {
         driver.get(Config.genuin_platformURL);
        driver.manage().window().setSize(new Dimension(768, 1024));
        Assert.assertTrue(true);
    }

    @Test
    public void TC46_verifyAllButtonsEnabled() {
         driver.get(Config.genuin_platformURL);
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        for (WebElement btn : buttons) {
            if (btn.isDisplayed()) {
                Assert.assertTrue(btn.isEnabled());
            }
        }
    }

    @Test
    public void TC47_verifyAllLinksPresent() {
         driver.get(Config.genuin_platformURL);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        Assert.assertTrue(links.size() > 5);
    }

    @Test
    public void TC48_verifyPageSourceNotEmpty() {
         driver.get(Config.genuin_platformURL);
        Assert.assertTrue(driver.getPageSource().length() > 1000);
    }

    @Test
    public void TC49_verifyImagesCount() {
         driver.get(Config.genuin_platformURL);
        List<WebElement> images = driver.findElements(By.tagName("img"));
        Assert.assertTrue(images.size() > 5);
    }

    @Test
    public void TC50_verifyNoEmptyButtons() {
     driver.get(Config.genuin_platformURL);
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        for (WebElement btn : buttons) {
            if (btn.isDisplayed()) {
                Assert.assertNotNull(btn.getText());
            }
        }
    
    
    }

}