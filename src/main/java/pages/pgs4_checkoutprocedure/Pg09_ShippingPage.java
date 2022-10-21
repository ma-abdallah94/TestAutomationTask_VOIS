package pages.pgs4_checkoutprocedure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Pg09_ShippingPage {
    private WebDriver driver ;
    private By proceedToCheckOutShipping = By.xpath("//button[@class=\"button btn btn-default standard-checkout button-medium\"]");
    private By agreementCheckBox         = By.id("cgv");


    public Pg09_ShippingPage(WebDriver driver) {
        this.driver=driver;
    }

    public Pg09_ShippingPage clickOnAgreementCheckBox(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(agreementCheckBox));
        driver.findElement(agreementCheckBox).click();
        return this;
    }

    public Pg10_PaymentMethodPage clickOnProceedToCheckoutInShippingPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckOutShipping));
        driver.findElement(proceedToCheckOutShipping).click();
        return new Pg10_PaymentMethodPage(driver);
    }
}
