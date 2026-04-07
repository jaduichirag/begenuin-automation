package tests;

import base.BaseTest;
import pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import utils.Config;
public class HeroTest extends BaseTest {

    @Test
    public void TC01_verifyHeroSection() {
           driver.get(Config.BASE_URL );
        HomePage home = new HomePage(driver, wait);
        Assert.assertTrue(home.isHeroVisible());
    }

    @Test
    public void TC02_verifyHeroTitleText() {
           driver.get(Config.BASE_URL );
        WebElement title = driver.findElement(By.xpath("//p[contains(text(),'Generative')]"));
        Assert.assertTrue(title.isDisplayed());
    }

    @Test
    public void TC03_verifyWatchButtonVisible() {
           driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Watch')]")).isDisplayed());
    }

    @Test
    public void TC04_verifyConnectButtonVisible() {
           driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Connect')]")).isDisplayed());
    }

    @Test
    public void TC05_verifyVideoPresent() {
           driver.get(Config.BASE_URL );
        HomePage home = new HomePage(driver, wait);
        Assert.assertTrue(home.isVideoPresent());
    }

    @Test
    public void Tc_06verifyVideoAutoplay() {
           driver.get(Config.BASE_URL );
        WebElement video = driver.findElement(By.tagName("video"));
        Assert.assertNotNull(video.getAttribute("autoplay"));
    }

    @Test
    public void TC07_verifyVideoMuted() {
   driver.get(Config.BASE_URL );
        WebElement video = driver.findElement(By.tagName("video"));
        Assert.assertNotNull(video.getAttribute("muted"));
    }


    @Test
    public void TC09_verifyVideoLoop() {
           driver.get(Config.BASE_URL );
        WebElement video = driver.findElement(By.tagName("video"));
        Assert.assertNotNull(video.getAttribute("loop"));
    }
}