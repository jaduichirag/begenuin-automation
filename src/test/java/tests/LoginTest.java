package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    String url = "https://your-login-url"; // replace this

    @Test
    public void TC01_verifyLoginPageLoads() {
        LoginPage login = new LoginPage(driver);
        login.openLoginPage(url);

        Assert.assertTrue(driver.getTitle().contains("Log In"));
    }

    @Test
    public void TC02_verifyLoginButtonDisabledInitially() {
        LoginPage login = new LoginPage(driver);
        login.openLoginPage(url);

        Assert.assertFalse(login.isLoginButtonEnabled());
    }

    @Test
    public void TC03_verifyLoginButtonEnabledAfterInput() {
        LoginPage login = new LoginPage(driver);
        login.openLoginPage(url);

        login.enterEmail("test@mail.com");
        login.enterPassword("123456");

        Assert.assertTrue(login.isLoginButtonEnabled());
    }

    @Test
    public void TC04_verifyForgotPasswordNavigation() {
        LoginPage login = new LoginPage(driver);
        login.openLoginPage(url);

        login.clickForgotPassword();

        Assert.assertTrue(driver.getCurrentUrl().contains("forgot-password"));
    }

    @Test
    public void TC05_verifySignUpNavigation() {
        LoginPage login = new LoginPage(driver);
        login.openLoginPage(url);

        login.clickSignUp();

        Assert.assertTrue(driver.getCurrentUrl().contains("signup"));
    }
}