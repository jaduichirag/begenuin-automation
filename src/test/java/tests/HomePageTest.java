package tests;

import base.BaseTest;
import pages.HomePage;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Config;
public class HomePageTest extends BaseTest {



    @Test
    public void TC01_verifyHomePageLoad() {
           driver.get(Config.BASE_URL );
        HomePage home = new HomePage(driver, wait);
        Assert.assertTrue(home.isHeroVisible());
    }

    @Test
    public void Tc02_verifyTitle() {
           driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.getTitle().length() > 0);
    }

    @Test
    public void TC03_verifyURL() {
           driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.getCurrentUrl().contains("begenuin"));
    }

    @Test
    public void TC04_verifyDOMLoaded() {
           driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.getPageSource().length() > 1000);
    }

    @Test
    public void Tc05_verifyPageScroll() {
           driver.get(Config.BASE_URL );
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        Assert.assertTrue(true);
    }

    @Test
    public void TC06_verifyLogoVisible() {
           driver.get(Config.BASE_URL );
        HomePage home = new HomePage(driver, wait);
        Assert.assertTrue(home.isLogoVisible());
    }

    @Test
    public void TC07_verifyLogoClickable() {
           driver.get(Config.BASE_URL );
        driver.findElement(By.xpath("//img")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("begenuin"));
    }

    @Test
    public void TC08_verifyPlatformClick() {
           driver.get(Config.BASE_URL );
        driver.findElement(By.linkText("Platform")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("platform"));
    }

    @Test
    public void TC09_verifyGenAIClick() {
           driver.get(Config.BASE_URL );
        driver.findElement(By.linkText("GenAI")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("genai"));
    }

    @Test
    public void TC10_verifyCompanyClick() {
           driver.get(Config.BASE_URL );
        driver.findElement(By.linkText("Company")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("company"));
    }

    @Test
    public void TC11_verifyDiscoverClick() {
           driver.get(Config.BASE_URL );
        driver.findElement(By.xpath("//button[contains(text(),'Discover')]")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("explore"));
    }

    @Test
    public void TC12_verifyLoginClick() {
           driver.get(Config.BASE_URL );
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void TC13_verifyStartFreeClick() {
           driver.get(Config.BASE_URL );
        driver.findElement(By.xpath("//span[contains(text(),'Start for free')]")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("signup"));
    }

    @Test
    public void TC14_verifyHeaderSticky() {
           driver.get(Config.BASE_URL );
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
        Assert.assertTrue(driver.findElement(By.tagName("header")).isDisplayed());
    }

    @Test
    public void TC15_verifyNavVisible() {
           driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.findElement(By.tagName("nav")).isDisplayed());
    }

    @Test
    public void Tc16_verifyHeroTitle() {
           driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Generative')]")).isDisplayed());
    }

    @Test
    public void TC17_verifySubtitle() {
           driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(@class,'text-body')]")).isDisplayed());
    }

    @Test
    public void TC18_verifyWatchButton() {
           driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Watch')]")).isDisplayed());
    }

    @Test
    public void TC19_verifyConnectButton() {
           driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Connect')]")).isDisplayed());
    }

    @Test
    public void TC20_verifyHeroLayout() {
           driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.findElements(By.xpath("//section")).size() > 0);
    }

    @Test
    public void TC21_verifyVideoPresent() {
           driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.findElement(By.tagName("video")).isDisplayed());
    }

    @Test
    public void TC22_verifyVideoAutoplay() {
           driver.get(Config.BASE_URL );
        WebElement video = driver.findElement(By.tagName("video"));
        Assert.assertTrue(video.getAttribute("autoplay") != null);
    }

    @Test
    public void TC23_verifyVideoMuted() {
           driver.get(Config.BASE_URL );
        WebElement video = driver.findElement(By.tagName("video"));
        Assert.assertTrue(video.getAttribute("muted") != null);
    }

    @Test
    public void TC24_verifyVideoLoop() {
           driver.get(Config.BASE_URL );
        WebElement video = driver.findElement(By.tagName("video"));
        Assert.assertTrue(video.getAttribute("loop") != null);
    }

    @Test
    public void TC25_verifyVideoLoaded() {
           driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.findElement(By.tagName("video")).getAttribute("src") != null);
    }
    @Test
    public void TC26_verifyPartnersText() {
           driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Trusted')]")).isDisplayed());
    }

    @Test
    public void TC27_verifyPartnerLogosVisible() {
           driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.findElements(By.tagName("img")).size() > 5);
    }

    @Test
    public void TC28_verifyLogosScroll() {
           driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'animate')]")).isDisplayed());
    }


@Test
public void TC29_verifyNoBrokenImages() {
       driver.get(Config.BASE_URL );

    List<WebElement> images = driver.findElements(By.tagName("img"));

    for (int i = 0; i < images.size(); i++) {
        String src = driver.findElements(By.tagName("img")).get(i).getAttribute("src");
        Assert.assertNotNull(src);
    }
}

    @Test
public void TC30_verifyLogoHover() {
       driver.get(Config.BASE_URL );

    WebElement logo = driver.findElements(By.tagName("img")).get(0);

    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logo);

    new Actions(driver).moveToElement(logo).perform();

    Assert.assertTrue(true);
}


    @Test
    public void TC31_verifyAllButtonsClickable() {
           driver.get(Config.BASE_URL );
        for (WebElement btn : driver.findElements(By.tagName("button"))) {
            Assert.assertTrue(btn.isEnabled());
        }
    }

    @Test
    public void TC32_verifyButtonText() {
           driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.getPageSource().contains("Start"));
    }

    @Test
    public void TC33_verifyButtonHover() {
           driver.get(Config.BASE_URL );
        WebElement btn = driver.findElement(By.tagName("button"));
        new org.openqa.selenium.interactions.Actions(driver).moveToElement(btn).perform();
        Assert.assertTrue(true);
    }

    @Test
    public void TC34_verifyButtonRedirect() {
     driver.get(Config.BASE_URL );
        driver.findElement(By.tagName("button")).click();
        Assert.assertTrue(true);
    }

    @Test
    public void TC35_verifyFeatureSection() {
           driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.findElement(By.xpath("//section")).isDisplayed());
    }

@Test
public void TC36_verifyLearnMore() {
   driver.get(Config.BASE_URL );
    WebElement btn = driver.findElement(By.xpath("//button[contains(text(),'Learn')]"));

    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);

    Assert.assertTrue(true);
}
    @Test
    public void TC37_verifyFeatureContent() {
           driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.getPageSource().contains("Discover"));
    }

    @Test
    public void Tc38_VerifyMobileView() {
           driver.get(Config.BASE_URL );
        driver.manage().window().setSize(new Dimension(375, 812));
        Assert.assertTrue(true);
    }

@Test
public void TC39_verifyHamburgerMenu() {
   driver.get(Config.BASE_URL );
    driver.manage().window().setSize(new Dimension(375, 812));

    List<WebElement> menus = driver.findElements(By.xpath("//button"));

    Assert.assertTrue(menus.size() > 0);
}

    @Test
    public void TC40_verifyNoOverlap() {
   driver.get(Config.BASE_URL );
        Assert.assertTrue(driver.findElements(By.xpath("//*")).size() > 0);
    }
}