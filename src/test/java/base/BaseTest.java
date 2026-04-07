package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.Optional;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public DevTools devTools;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
     //ChromeDriver chrome = new ChromeDriver();
        driver = new ChromeDriver();
        System.out.println("Driver initialized");
       driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    
     
        
  try {
            devTools = ((HasDevTools) driver).getDevTools();
            devTools.createSession();
                   } catch (Exception e) {
            System.out.println("DevTools not supported");
        }
    
   }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}