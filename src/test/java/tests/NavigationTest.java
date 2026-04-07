package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Config;
public class NavigationTest extends BaseTest {

    @Test
    public void TC01_verifyPlatformNavigation() {
           driver.get(Config.BASE_URL );
        By platform = By.xpath("//a[text()='Platform']");
        wait.until(ExpectedConditions.elementToBeClickable(platform)).click();

        wait.until(ExpectedConditions.urlContains("platform"));
        Assert.assertTrue(driver.getCurrentUrl().contains("platform"));
    }

    @Test
    public void TC02_verifyGenAINavigation() {
           driver.get(Config.BASE_URL );
        By genai = By.linkText("GenAI");
        wait.until(ExpectedConditions.elementToBeClickable(genai)).click();

        wait.until(ExpectedConditions.urlContains("genai"));
        Assert.assertTrue(driver.getCurrentUrl().contains("genai"));
    }

    @Test
    public void TC03_verifyCompanyNavigation() {
           driver.get(Config.BASE_URL );
        By company = By.linkText("Company");
        wait.until(ExpectedConditions.elementToBeClickable(company)).click();

        wait.until(ExpectedConditions.urlContains("company"));
        Assert.assertTrue(driver.getCurrentUrl().contains("company"));
    }

    @Test
    public void TC04verifyExploreNavigation() {
           driver.get(Config.BASE_URL );
        By explore = By.xpath("//button[contains(text(),'Discover')]");
        wait.until(ExpectedConditions.elementToBeClickable(explore)).click();

        wait.until(ExpectedConditions.urlContains("explore"));
        Assert.assertTrue(driver.getCurrentUrl().contains("explore"));
    }
}