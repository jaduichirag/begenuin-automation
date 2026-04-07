package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // HEADER
    By logo = By.xpath("//img[contains(@alt,'Genuin')]");
    By platform = By.xpath("//a[contains(text(),'Platform')]");
    By genai = By.xpath("//a[contains(text(),'GenAI')]");
    By company = By.xpath("//a[contains(text(),'Company')]");
    By login = By.xpath("//button[contains(text(),'Log in')]");
    By startFree = By.xpath("//span[contains(text(),'Start for free')]");

    // HERO
    By heroTitle = By.xpath("//p[contains(text(),'Generative')]");
    By watchBtn = By.xpath("//span[contains(text(),'Watch')]");
    By connectBtn = By.xpath("//span[contains(text(),'Connect')]");

    // VIDEO
    By video = By.xpath("//video");

    // PARTNERS
    By partnersText = By.xpath("//p[contains(text(),'Trusted')]");
    By logos = By.xpath("//img[contains(@src,'sanity')]");

    // FEATURE
    By learnMore = By.xpath("//button[contains(text(),'Learn more')]");

    // ACTION METHODS

    public boolean isLogoVisible() {
        return driver.findElement(logo).isDisplayed();
    }

    public void clickLogin() {
        driver.findElement(login).click();
    }

    public void clickPlatform() {
        driver.findElement(platform).click();
    }

    public boolean isHeroVisible() {
        return driver.findElement(heroTitle).isDisplayed();
    }

    public boolean isVideoPresent() {
        return driver.findElement(video).isDisplayed();
    }

    public boolean isPartnersVisible() {
        return driver.findElement(partnersText).isDisplayed();
    }

    public int getLogoCount() {
        return driver.findElements(logos).size();
    }

    public void clickLearnMore() {
        driver.findElement(learnMore).click();
    }
}