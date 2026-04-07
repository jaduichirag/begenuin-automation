package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Config;
public class PlatformHeroTest extends BaseTest {

    @Test
    public void TC06_verifyHeroTitle() {
        driver.get(Config.genuin_platformURL);

        Assert.assertTrue(driver.findElement(
                By.xpath("//*[contains(text(),'Own the Social Experience')]"))
                .isDisplayed());
    }

    @Test
    public void TC07_verifyHeroImage() {
        driver.get(Config.genuin_platformURL);

        Assert.assertTrue(driver.findElement(
                By.xpath("//img[contains(@src,'sanity')]"))
                .isDisplayed());
    }

    @Test
    public void TC08_verifyExploreBrandSafety() {
        driver.get(Config.genuin_platformURL);

        driver.findElement(By.xpath("//button[contains(text(),'Explore Brand Safety')]")).click();
        Assert.assertTrue(true);
    }
     
      @Test
public void TC09_verifyHeroTextNotEmpty() {
     driver.get(Config.genuin_platformURL);
    String text = driver.findElement(By.xpath("//*[contains(text(),'Own the Social Experience')]")).getText();
    Assert.assertFalse(text.isEmpty());
}

@Test
public void TC10_verifyHeroImageLoaded() {
    
     driver.get(Config.genuin_platformURL);
    WebElement img = driver.findElement(By.xpath("//img[contains(@src,'sanity')]"));
    Assert.assertTrue(img.getAttribute("src") != null);
}

@Test
public void TC11_verifyCTAButtonVisible() {
    
     driver.get(Config.genuin_platformURL);
    Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Explore')]")).isDisplayed());
}
}