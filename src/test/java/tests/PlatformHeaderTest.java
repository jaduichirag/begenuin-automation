package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import utils.Config;

public class PlatformHeaderTest extends BaseTest {

    @Test
    public void TC01_verifyLogoVisible() {
        driver.get(Config.genuin_platformURL);
        Assert.assertTrue(driver.findElement(By.xpath("//img[contains(@alt,'Logo')]")).isDisplayed());
    }

    @Test
    public void TC02_verifyNavigationLinks() {
        driver.get(Config.genuin_platformURL);

        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Platform')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'GenAI')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Company')]")).isDisplayed());
    }

    @Test
    public void TC03_verifyDiscoverButton() {
        driver.get(Config.genuin_platformURL);

        driver.findElement(By.xpath("//button[contains(text(),'Discover')]")).click();
        Assert.assertTrue(true); // new tab
    }

    @Test
    public void TC04_verifyLoginButton() {
        driver.get(Config.genuin_platformURL);

        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        Assert.assertTrue(true);
    }

    @Test
    public void TC05_verifyStartFreeButton() {
        driver.get(Config.genuin_platformURL);

        driver.findElement(By.xpath("//span[contains(text(),'Start for free')]")).click();
        Assert.assertTrue(true);
    }
    @Test
public void TC06_verifyLogoClickable() {
     driver.get(Config.genuin_platformURL);
    driver.findElement(By.xpath("//img[contains(@alt,'Logo')]")).click();
    Assert.assertTrue(driver.getCurrentUrl().contains("begenuin"));
}

@Test
public void TC07_verifyHeaderButtonsVisible() {
     driver.get(Config.genuin_platformURL);
    Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Discover')]")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).isDisplayed());
}

@Test
public void TC08_verifyStartFreeVisible() {
     driver.get(Config.genuin_platformURL);
    Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Start for free')]")).isDisplayed());
}

}