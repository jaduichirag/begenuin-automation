package pages; 
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
public class PlatformPage {

    WebDriver driver;
    WebDriverWait wait;

    public PlatformPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Header
    By logo = By.xpath("//img[contains(@alt,'Logo')]");
    By discoverBtn = By.xpath("//button[contains(text(),'Discover')]");
    By loginBtn = By.xpath("//button[contains(text(),'Log in')]");
    By startFreeBtn = By.xpath("//span[contains(text(),'Start for free')]");

    // Hero
    By heroTitle = By.xpath("//*[contains(text(),'Own the Social Experience')]");
    By heroImage = By.xpath("//img[contains(@alt,'Feature Image')]");

    // Features
    By whiteLabelBtn = By.xpath("//button[contains(text(),'White-label')]");
    By quickStartBtn = By.xpath("//button[contains(text(),'Quick Start')]");

    public boolean isLogoVisible() {
        return driver.findElement(logo).isDisplayed();
    }

    public boolean isHeroVisible() {
        return driver.findElement(heroTitle).isDisplayed();
    }

    public void clickDiscover() {
        driver.findElement(discoverBtn).click();
    }
}