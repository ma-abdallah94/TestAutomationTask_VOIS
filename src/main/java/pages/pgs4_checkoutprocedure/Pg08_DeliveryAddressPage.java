package pages.pgs4_checkoutprocedure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Pg08_DeliveryAddressPage {
    private WebDriver driver ;
    private By proceedToCheckOutAddress = By.xpath("//button[@class=\"button btn btn-default button-medium\"]");


    public Pg08_DeliveryAddressPage(WebDriver driver) {
        this.driver=driver ;
    }

    public Pg09_ShippingPage clickOnProceedToCheckoutInAddressPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckOutAddress));
        driver.findElement(proceedToCheckOutAddress).click();
        return new Pg09_ShippingPage(driver);
    }
}
