package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


/**
 * A Point of View : Sometimes we don't have to create the BaseTest Class and initialize driver At any Test class
 * so using baseTest in case we are building  a full framework dealing with cookies ,cucumber , screenshots,..etc
 * For more code organizing and declaring WebDriver driver once per TestClass .
 */

public class BaseTest {

    protected WebDriver driver ;

    public WebDriver driverInitializer(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1024 , 768));
        //* ImplicitlyWait Works fine with this project , But it's not the best practice in case of shadow DOM
        //Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //So We will use Explicitly Waits or Fluent Waits */
        return driver ;
    }

    @BeforeMethod
    public void setup() {
        driver =new BaseTest().driverInitializer();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
