package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import utils.Config;
public class PlatformFeatureTest extends BaseTest {

    @Test
    public void TC09_verifyInfrastructureSection() {
        driver.get(Config.genuin_platformURL);

        Assert.assertTrue(driver.findElement(
                By.xpath("//*[contains(text(),'Integrate Full Stack Infrastructure')]"))
                .isDisplayed());
    }

    @Test
    public void TC10_verifyWhiteLabelButton() {
        driver.get(Config.genuin_platformURL);

        driver.findElement(By.xpath("//button[contains(text(),'White-label')]")).click();
        Assert.assertTrue(true);
    }

    @Test
    public void TC11_verifyQuickStartButton() {
        driver.get(Config.genuin_platformURL);

        driver.findElement(By.xpath("//button[contains(text(),'Quick Start')]")).click();
        Assert.assertTrue(true);
    }

    @Test
    public void TC12_verifyAISection() {
        driver.get(Config.genuin_platformURL);

        Assert.assertTrue(driver.findElement(
                By.xpath("//*[contains(text(),'Adaptive Intelligence')]"))
                .isDisplayed());
    }
@Test
public void TC13_verifyFeatureImagesPresent() {
    driver.get(Config.genuin_platformURL);
    Assert.assertTrue(driver.findElements(By.tagName("img")).size() > 3);
}

@Test
public void TC14_verifySectionTextPresent() {
    driver.get(Config.genuin_platformURL);
    Assert.assertTrue(driver.getPageSource().contains("Integrate"));
}

@Test
public void TC15_verifyQuickStartVisible() {
    driver.get(Config.genuin_platformURL);
    Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Quick Start')]")).isDisplayed());
}

@Test
public void TC16_verifyWhiteLabelVisible() {
    driver.get(Config.genuin_platformURL);
    Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'White')]")).isDisplayed());
}


}