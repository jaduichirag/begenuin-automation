package tests;

import base.BaseTest;
import pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Config;
public class HeaderTest extends BaseTest {

    @Test
    public void TC01_verifyLogoVisible() {
           driver.get(Config.BASE_URL );
        HomePage home = new HomePage(driver, wait);
        Assert.assertTrue(home.isLogoVisible());
    }

    @Test
    public void TC02_verifyLogoClickRedirectsHome() {
           driver.get(Config.BASE_URL );
        driver.findElement(By.xpath("//img")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("begenuin"));
    }

    @Test
    public void TC03_verifyPlatformNavigation() {
           driver.get(Config.BASE_URL );
        HomePage home = new HomePage(driver, wait);
        home.clickPlatform();

        wait.until(ExpectedConditions.urlContains("platform"));
        Assert.assertTrue(driver.getCurrentUrl().contains("platform"));
    }

    @Test
    public void TC04_verifyGenAINavigation() {
           driver.get(Config.BASE_URL );
        driver.findElement(By.linkText("GenAI")).click();

        wait.until(ExpectedConditions.urlContains("genai"));
        Assert.assertTrue(driver.getCurrentUrl().contains("genai"));
    }

    @Test
    public void TC05_verifyCompanyNavigation() {
           driver.get(Config.BASE_URL );
        driver.findElement(By.linkText("Company")).click();

        wait.until(ExpectedConditions.urlContains("company"));
        Assert.assertTrue(driver.getCurrentUrl().contains("company"));
    }

    @Test
    public void TC06_verifyHeaderVisible() {
           driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.findElement(By.tagName("header")).isDisplayed());
    }

    @Test
    public void TC07_verifyNavigationMenuVisible() {
           driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.findElement(By.tagName("nav")).isDisplayed());
    }
}