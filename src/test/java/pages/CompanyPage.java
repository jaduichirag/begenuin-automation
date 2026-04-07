package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompanyPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public CompanyPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    By logo = By.xpath("//img");
    By platformLink = By.linkText("Platform");
    By genaiLink = By.linkText("GenAI");
    By companyLink = By.linkText("Company");
    By loginBtn = By.xpath("//button[contains(text(),'Log in')]");
    By startFreeBtn = By.xpath("//span[contains(text(),'Start for free')]");


    By heroSection = By.tagName("body"); // generic fallback
    By heroImage = By.tagName("img");
    By teamImages = By.tagName("img");
    By allButtons = By.tagName("button");
    By footer = By.tagName("footer");
    public boolean isLogoVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logo)).isDisplayed();
    }

    public void clickLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(logo)).click();
    }

    public boolean isPlatformVisible() {
        return driver.findElement(platformLink).isDisplayed();
    }

    public void clickPlatform() {
        wait.until(ExpectedConditions.elementToBeClickable(platformLink)).click();
    }

    public boolean isLoginVisible() {
        return driver.findElement(loginBtn).isDisplayed();
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public boolean isStartFreeVisible() {
        return driver.findElement(startFreeBtn).isDisplayed();
    }


    public boolean isHeroVisible() {
        return driver.findElement(heroSection).isDisplayed();
    }

    public boolean isHeroImagePresent() {
        return driver.findElement(heroImage).isDisplayed();
    }

    public boolean isHeroTextPresent() {
        return driver.findElement(heroSection).getText().length() > 0;
    }


    public int getTeamImageCount() {
        return driver.findElements(teamImages).size();
    }

    public boolean areImagesLoaded() {
        for (WebElement img : driver.findElements(teamImages)) {
            if (img.getAttribute("src") == null) {
                return false;
            }
        }
        return true;
    }

    public int getButtonCount() {
        return driver.findElements(allButtons).size();
    }

    public boolean areButtonsEnabled() {
        for (WebElement btn : driver.findElements(allButtons)) {
            if (btn.isDisplayed() && !btn.isEnabled()) {
                return false;
            }
        }
        return true;
    }


    public int getAllLinksCount() {
        return driver.findElements(By.tagName("a")).size();
    }

    public int getAllImagesCount() {
        return driver.findElements(By.tagName("img")).size();
    }

    public boolean isFooterVisible() {
        return driver.findElement(footer).isDisplayed();
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
    }

    public void setMobileView() {
        driver.manage().window().setSize(new Dimension(375, 812));
    }

    public void setTabletView() {
        driver.manage().window().setSize(new Dimension(768, 1024));
    }
}