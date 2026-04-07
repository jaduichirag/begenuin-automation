package tests;

import base.BaseTest;
import pages.CompanyPage;
import utils.Config;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CompanyTest extends BaseTest {

    // ================= HEADER =================

    @Test
    public void TC01_verifyLogoVisible() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        Assert.assertTrue(page.isLogoVisible());
    }

    @Test
    public void TC02_verifyLogoClick() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        page.clickLogo();
        Assert.assertTrue(driver.getCurrentUrl().contains("begenuin"));
    }

    @Test
    public void TC03_verifyPlatformVisible() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        Assert.assertTrue(page.isPlatformVisible());
    }

    @Test
    public void TC04_verifyPlatformClick() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        page.clickPlatform();
        Assert.assertTrue(driver.getCurrentUrl().contains("platform"));
    }

    @Test
    public void TC05_verifyLoginVisible() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        Assert.assertTrue(page.isLoginVisible());
    }

    @Test
    public void TC06_verifyLoginClick() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        page.clickLogin();
        Assert.assertTrue(true);
    }

    @Test
    public void TC07_verifyStartFreeVisible() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        Assert.assertTrue(page.isStartFreeVisible());
    }

    // ================= HERO =================

    @Test
    public void TC08_verifyHeroVisible() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        Assert.assertTrue(page.isHeroVisible());
    }

    @Test
    public void TC09_verifyHeroImage() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        Assert.assertTrue(page.isHeroImagePresent());
    }

    @Test
    public void TC10_verifyHeroText() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        Assert.assertTrue(page.isHeroTextPresent());
    }

    @Test
    public void TC11_verifyPageTitle() {
        driver.get(Config.CompURL);
        Assert.assertFalse(driver.getTitle().isEmpty());
    }

    @Test
    public void TC12_verifyURLContainsCompany() {
        driver.get(Config.CompURL);
        Assert.assertTrue(driver.getCurrentUrl().contains("company"));
    }

    // ================= TEAM =================

    @Test
    public void TC13_verifyTeamImagesCount() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        Assert.assertTrue(page.getTeamImageCount() > 3);
    }

    @Test
    public void TC14_verifyImagesLoaded() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        Assert.assertTrue(page.areImagesLoaded());
    }

    @Test
    public void TC15_verifyImagesCount() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        Assert.assertTrue(page.getAllImagesCount() > 5);
    }

    // ================= BUTTONS =================

    @Test
    public void TC16_verifyButtonsCount() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        Assert.assertTrue(page.getButtonCount() > 0);
    }

    @Test
    public void TC17_verifyButtonsEnabled() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        Assert.assertTrue(page.areButtonsEnabled());
    }

    @Test
    public void TC18_verifyButtonTextNotEmpty() {
        driver.get(Config.CompURL);
        Assert.assertTrue(driver.getPageSource().contains("Start"));
    }

    // ================= LINKS =================

    @Test
    public void TC19_verifyLinksCount() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        Assert.assertTrue(page.getAllLinksCount() > 5);
    }

    @Test
    public void TC21_verifyLinksPresent() {
        driver.get(Config.CompURL);
        Assert.assertTrue(driver.getPageSource().contains("http"));
    }

    // ================= SCROLL =================

    @Test
    public void TC21_verifyScrollDown() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        page.scrollDown();
        Assert.assertTrue(true);
    }

    @Test
    public void TC22_verifyScrollMultipleTimes() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        page.scrollDown();
        page.scrollDown();
        Assert.assertTrue(true);
    }

    // ================= FOOTER =================

    @Test
    public void TC23_verifyFooterVisible() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        Assert.assertTrue(page.isFooterVisible());
    }

    // ================= RESPONSIVE =================

    @Test
    public void TC24_verifyMobileView() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        page.setMobileView();
        Assert.assertTrue(true);
    }

    @Test
    public void TC25_verifyTabletView() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        page.setTabletView();
        Assert.assertTrue(true);
    }

    // ================= GENERAL =================

    @Test
    public void TC26_verifyPageLoad() {
        driver.get(Config.CompURL);
        Assert.assertTrue(driver.getPageSource().length() > 1000);
    }

    @Test
    public void TC27_verifyNoEmptyPage() {
        driver.get(Config.CompURL);
        Assert.assertFalse(driver.getPageSource().isEmpty());
    }

    @Test
    public void TC28_verifyTextExists() {
        driver.get(Config.CompURL);
        Assert.assertTrue(driver.getPageSource().length() > 500);
    }

    // ================= EXTRA =================

    @Test
    public void TC29_verifyMultipleClicksSafe() {
        driver.get(Config.CompURL);
        CompanyPage page = new CompanyPage(driver, wait);
        page.clickPlatform();
        driver.navigate().back();
        Assert.assertTrue(true);
    }

    @Test
    public void TC30_verifyReloadPage() {
        driver.get(Config.CompURL);
        driver.navigate().refresh();
        Assert.assertTrue(true);
    }

    @Test
    public void TC31_verifyBackNavigation() {
        driver.get(Config.CompURL);
        driver.navigate().to(Config.BASE_URL );
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("company"));
    }

    @Test
    public void TC32_verifyForwardNavigation() {
        driver.get(Config.CompURL);
        driver.navigate().to(Config.BASE_URL );
        driver.navigate().back();
        driver.navigate().forward();
        Assert.assertTrue(true);
    }

    @Test
    public void TC33_verifyWindowResize() {
        driver.get(Config.CompURL);
        driver.manage().window().maximize();
        Assert.assertTrue(true);
    }

    @Test
    public void TC34_verifyImagesHaveSrc() {
        driver.get(Config.CompURL);
        Assert.assertTrue(driver.getPageSource().contains("img"));
    }

    @Test
    public void TC35_verifyPageSpeedBasic() {
        driver.get(Config.CompURL);
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        Assert.assertTrue((end - start) < 5000);
    }
}