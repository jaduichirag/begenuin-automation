package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GenAiPage {

    WebDriver driver;
    WebDriverWait wait;

    public GenAiPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // ================= HEADER =================

    By logo = By.xpath("//img[contains(@alt,'Genuin')]");
    By platform = By.xpath("//a[contains(@href,'platform')]");
    By genai = By.xpath("//a[contains(@href,'genai')]");
    By company = By.xpath("//a[contains(@href,'company')]");

    By loginBtn = By.xpath("//button[contains(text(),'Log in')]");
    By startFreeBtn = By.xpath("//span[contains(text(),'Start for free')]");

    // ================= HERO =================

    By heroTitle = By.xpath("//p[contains(text(),'Adaptive Intelligence')]");
    By heroSubtitle = By.xpath("//p[contains(text(),'Explore contextual relevance')]");

    // ================= AGENTS =================

    By agentsSection = By.xpath("//span[contains(text(),'GenAI Agents')]");
    By agentCards = By.xpath("//div[contains(@class,'rounded-2xl')]");
    By agentImages = By.xpath("//img[contains(@src,'agents')]");

    By startButtons = By.xpath("//button[text()='Start']");

    // ================= CHAT =================

    By chatBox = By.xpath("//textarea[contains(@placeholder,'Type your message')]");
//    By sendBtn = By.xpath("//button[contains(@class,'rounded-full')]");

    By sendBtn = By.xpath("//textarea[@placeholder='Type your message here...']/following::button[@data-slot='button'][1]");
    By uploadBtn = By.xpath("//input[@type='file']");

    // ================= HEADER METHODS =================

    public boolean isLogoVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logo)).isDisplayed();
    }

    public void clickPlatform() {
        wait.until(ExpectedConditions.elementToBeClickable(platform)).click();
    }

    public boolean isGenAiActive() {
        return driver.getCurrentUrl().contains("genai");
    }

    public void clickCompany() {
        wait.until(ExpectedConditions.elementToBeClickable(company)).click();
    }

    public boolean isLoginVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).isDisplayed();
    }

    public boolean isStartFreeVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(startFreeBtn)).isDisplayed();
    }

    // ================= HERO METHODS =================

    public boolean isHeroTitleVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(heroTitle)).isDisplayed();
    }

    public boolean isHeroSubtitleVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(heroSubtitle)).isDisplayed();
    }

    // ================= AGENTS METHODS =================

    public boolean isAgentsSectionVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(agentsSection)).isDisplayed();
    }

    public int getAgentsCount() {
        return driver.findElements(agentCards).size();
    }

    public boolean areAgentImagesDisplayed() {
        List<WebElement> imgs = driver.findElements(agentImages);
        return imgs.size() > 0 && imgs.get(0).isDisplayed();
    }

    public int getStartButtonCount() {
        return driver.findElements(startButtons).size();
    }

    public void clickFirstStart() {
        wait.until(ExpectedConditions.elementToBeClickable(startButtons)).click();
    }

    // ================= CHAT METHODS =================

    public boolean isChatBoxVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(chatBox)).isDisplayed();
    }

    public void enterMessage(String text) {
        WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(chatBox));
        box.clear();
        box.sendKeys(text);
    }

    public boolean isSendDisabled() {
        return !driver.findElement(sendBtn).isEnabled();
    }

    public boolean isSendEnabled() {
        return driver.findElement(sendBtn).isEnabled();
    }

    public boolean isUploadVisible() {
        return driver.findElement(uploadBtn).isDisplayed();
    }

    // ================= SCROLL =================

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }

    // ================= RESPONSIVE =================

    public void setMobileView() {
        driver.manage().window().setSize(new Dimension(375, 812));
    }

    public void setTabletView() {
        driver.manage().window().setSize(new Dimension(768, 1024));
    }

    // ================= LINKS =================

    public int getLinksCount() {
        return driver.findElements(By.tagName("a")).size();
    }
    // SEND BUTTON
public void clickSend() {
    driver.findElement(sendBtn).click();
}

// RESPONSE (generic locator, adjust if needed)
By response = By.xpath("//div[contains(@class,'message')]");

public boolean isResponseVisible() {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(response)).isDisplayed();
}

public String getResponseText() {
    return driver.findElement(response).getText();
}

public WebElement waitForResponse() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    return wait.until(ExpectedConditions.presenceOfElementLocated(
//        By.xpath("//div[contains(@class,'message')]")
       By.xpath ("//div[@id='chat-messages']//div[contains(@class,'justify-start')]//p)[last()]")

    ));
}
}