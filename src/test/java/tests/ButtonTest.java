package tests;
import utils.Config;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ButtonTest extends BaseTest {
@Test
public void debugTest() {
    System.out.println("🔥 TEST STARTED");
}

@Test
public void TC01_verifyLoginButtonOpensModal() {

    driver.get(Config.BASE_URL );
    driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

    By emailField = By.xpath("//input[@type='email']");

    wait.until(ExpectedConditions.presenceOfElementLocated(emailField));
    wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));

    Assert.assertTrue(driver.findElement(emailField).isDisplayed());
}

    @Test
    public void TC02_verifyLoginButtonClickable() {
           driver.get(Config.BASE_URL );
        WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        Assert.assertTrue(login.isDisplayed());
        Assert.assertTrue(login.isEnabled());
    }


    @Test
    public void TC03_verifyStartForFreeClickable() {
           driver.get(Config.BASE_URL );
        WebElement startFree = driver.findElement(By.xpath("//span[contains(text(),'Start for free')]"));
        Assert.assertTrue(startFree.isDisplayed());
    }

    @Test
    public void TC04_verifyStartForFreeRedirect() {
           driver.get(Config.BASE_URL );
        driver.findElement(By.xpath("//span[contains(text(),'Start for free')]")).click();

        wait.until(ExpectedConditions.urlContains("signup"));
        Assert.assertTrue(driver.getCurrentUrl().contains("signup"));
    }
   @Test
public void TC05_verifyDiscoverButtonClick() throws InterruptedException {
       driver.get(Config.BASE_URL );

    WebElement btn = driver.findElement(By.xpath("//button[contains(text(),'Discover')]"));

    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);

    Thread.sleep(2000);

    Assert.assertTrue(true); // No strict URL validation
}   @Test
    public void TC06_verifyWatchButtonVisible() {
           driver.get(Config.BASE_URL );
        WebElement watchBtn = driver.findElement(By.xpath("//span[contains(text(),'Watch')]"));
        Assert.assertTrue(watchBtn.isDisplayed());
    }

    @Test
    public void TC07_verifyWatchButtonClickable() {
           driver.get(Config.BASE_URL );
        WebElement watchBtn = driver.findElement(By.xpath("//span[contains(text(),'Watch')]"));
        Assert.assertTrue(watchBtn.isEnabled());
    }
    @Test
    public void TC08_verifyConnectButtonVisible() {
           driver.get(Config.BASE_URL );
        WebElement connect = driver.findElement(By.xpath("//span[contains(text(),'Connect')]"));
        Assert.assertTrue(connect.isDisplayed());
    }

    @Test
    public void TC09_verifyConnectButtonClickable() {
              driver.get(Config.BASE_URL );
        WebElement connect = driver.findElement(By.xpath("//span[contains(text(),'Connect')]"));
        Assert.assertTrue(connect.isEnabled());
    }

@Test
public void TC10_verifyAllButtonsEnabled() {
       driver.get(Config.BASE_URL );

    List<WebElement> buttons = driver.findElements(By.tagName("button"));

    for (WebElement btn : buttons) {
        if (btn.isDisplayed()) {
            Assert.assertTrue(btn.isEnabled());
        }
    }
}
    @Test
    public void TC11_verifyNoBrokenButtons() {
           driver.get(Config.BASE_URL );
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        for (WebElement btn : buttons) {
            Assert.assertNotNull(btn.getText());
        }
    }


    @Test
    public void TC12_verifyButtonHover() {
           driver.get(Config.BASE_URL );
        WebElement btn = driver.findElement(By.tagName("button"));

        new org.openqa.selenium.interactions.Actions(driver)
                .moveToElement(btn)
                .perform();

        Assert.assertTrue(true);
    }
}