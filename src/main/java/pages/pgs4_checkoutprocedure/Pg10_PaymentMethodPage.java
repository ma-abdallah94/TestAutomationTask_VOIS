package pages.pgs4_checkoutprocedure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Pg10_PaymentMethodPage {
    private WebDriver driver;
    private By payByBankWireOption = By.className("bankwire");


    public Pg10_PaymentMethodPage(WebDriver driver) {
        this.driver=driver;
    }

    public Pg11_BankWirePaymentPage clickOnPayByBankWireOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(payByBankWireOption));
        driver.findElement(payByBankWireOption).click();
        return new Pg11_BankWirePaymentPage(driver);
    }

}
