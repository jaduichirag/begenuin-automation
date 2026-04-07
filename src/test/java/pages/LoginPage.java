package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators (from your DOM)
    private By email = By.id("loginEmail");
    private By password = By.id("loginPassword");
    private By loginBtn = By.xpath("//button[normalize-space()='Log In']");
    private By forgotPassword = By.linkText("Forgot password");
    private By googleBtn = By.xpath("//span[text()='Continue with Google']");
    private By signUp = By.xpath("//a[contains(text(),'Sign up')]");

    // Actions
    public void openLoginPage(String url) {
        driver.get(url);
    }

    public void enterEmail(String emailText) {
        driver.findElement(email).sendKeys(emailText);
    }

    public void enterPassword(String passText) {
        driver.findElement(password).sendKeys(passText);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginBtn).isEnabled();
    }

    public void clickForgotPassword() {
        driver.findElement(forgotPassword).click();
    }

    public void clickGoogleLogin() {
        driver.findElement(googleBtn).click();
    }

    public void clickSignUp() {
        driver.findElement(signUp).click();
    }
}