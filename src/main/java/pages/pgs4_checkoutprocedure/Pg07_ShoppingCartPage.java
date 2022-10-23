package pages.pgs4_checkoutprocedure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pgs1_authentications.Pg01_AuthenticationPage;
import java.time.Duration;

public class Pg07_ShoppingCartPage {
    private WebDriver driver;
    private By proceedToCheckOutSummary = By.xpath("//a[@class=\"button btn btn-default standard-checkout button-medium\"]");


    public Pg07_ShoppingCartPage(WebDriver driver){
        this.driver=driver;
    }

    public Pg01_AuthenticationPage clickOnProceedToCheckoutButtonLoggedOutUserInShoppingCart(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckOutSummary));
        driver.findElement(proceedToCheckOutSummary).click();
        return new Pg01_AuthenticationPage(driver);
    }

    public Pg08_DeliveryAddressPage clickOnProceedToCheckoutButtonLoggedInUserInShoppingCart(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckOutSummary));
        driver.findElement(proceedToCheckOutSummary).click();
        return new Pg08_DeliveryAddressPage(driver);
    }
}