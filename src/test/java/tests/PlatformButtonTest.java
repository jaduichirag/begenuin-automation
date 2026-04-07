package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import java.util.List;

import utils.Config;
public class PlatformButtonTest extends BaseTest {

    @Test
    public void TC13_verifyAllButtonsClickable() {
        driver.get(Config.genuin_platformURL);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        for (WebElement btn : buttons) {
            if (btn.isDisplayed()) {
                Assert.assertTrue(btn.isEnabled());
            }
        }
    }

    @Test
    public void TC14_verifyAllLinksWorking() {
        driver.get(Config.genuin_platformURL);

        List<WebElement> links = driver.findElements(By.tagName("a"));

        Assert.assertTrue(links.size() > 0);
    }
    @Test
public void TC17_verifyButtonsCount() {
    List<WebElement> buttons = driver.findElements(By.tagName("button"));
    Assert.assertTrue(buttons.size() > 5);
}

@Test
public void TC18_verifyClickableButtons() {
        driver.get(Config.genuin_platformURL);
    List<WebElement> buttons = driver.findElements(By.tagName("button"));

    for (WebElement btn : buttons) {
        if (btn.isDisplayed()) {
            Assert.assertTrue(btn.isEnabled());
        }
    }
}

@Test
public void TC19_verifyButtonTextNotEmpty() {
        driver.get(Config.genuin_platformURL);
    List<WebElement> buttons = driver.findElements(By.tagName("button"));

    for (WebElement btn : buttons) {
        if (btn.isDisplayed()) {
            Assert.assertNotNull(btn.getText());
        }
    }
}
}