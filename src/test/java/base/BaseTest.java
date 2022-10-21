package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver ;

    public WebDriver driverInitializer(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1024 , 768));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // It Works fine with this project but not the best practice
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
