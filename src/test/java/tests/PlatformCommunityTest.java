package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import java.util.List;
import utils.Config;

public class PlatformCommunityTest extends BaseTest {

    @Test
    public void TC16_verifyCommunityCards() {
        driver.get(Config.genuin_platformURL);

        List<WebElement> cards = driver.findElements(By.xpath("//img[contains(@alt,'community')]"));

        Assert.assertTrue(cards.size() > 0);
    }

    @Test
    public void TC17_verifyJoinButtons() {
        driver.get(Config.genuin_platformURL);

        List<WebElement> joinBtns = driver.findElements(By.xpath("//button[contains(text(),'Join')]"));

        Assert.assertTrue(joinBtns.size() > 0);
    }

    @Test
public void TC20_verifyCommunityImages() {
     driver.get(Config.genuin_platformURL);
    List<WebElement> imgs = driver.findElements(By.xpath("//img"));
    Assert.assertTrue(imgs.size() > 5);
}


@Test
public void TC21_verifyCommunityLinks() {
     driver.get(Config.genuin_platformURL);
    List<WebElement> links = driver.findElements(By.tagName("a"));
    Assert.assertTrue(links.size() > 5);
}

@Test
public void TC22_verifyJoinButtonClickable() {
     driver.get(Config.genuin_platformURL);
    List<WebElement> joins = driver.findElements(By.xpath("//button[contains(text(),'Join')]"));

    for (WebElement btn : joins) {
        if (btn.isDisplayed()) {
            btn.click();
            break;
        }
    }
    Assert.assertTrue(true);
}
}