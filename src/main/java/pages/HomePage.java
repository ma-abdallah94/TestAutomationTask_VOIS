package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testdatautils.GettingPropertyData;

import java.time.Duration;

public class HomePage {

    private WebDriver driver ;
    private By signInBtn        = By.xpath("//a[@class=\"login\"]");

    public HomePage(WebDriver driver) {
            this.driver=driver;
    }

    public HomePage load(){
        driver.get(GettingPropertyData.getInstance().baseURL());
        return this;
    }

    public AuthenticationPage clickOnSignInButton(){
        driver.findElement(signInBtn).click();
        return new AuthenticationPage(driver);
    }
}
