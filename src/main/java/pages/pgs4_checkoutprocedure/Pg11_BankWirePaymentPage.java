package pages.pgs4_checkoutprocedure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Pg11_BankWirePaymentPage {
    private WebDriver driver;
    private By iConfirmMyOrderButton = By.xpath("//button[@class=\"button btn btn-default button-medium\"]");

    public Pg11_BankWirePaymentPage(WebDriver driver) {
        this.driver=driver;
    }

    public Pg12_OrderConfirmationPage clickOnIConfirmMyOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(iConfirmMyOrderButton));
        driver.findElement(iConfirmMyOrderButton).click();
        return new Pg12_OrderConfirmationPage(driver);
    }
}
