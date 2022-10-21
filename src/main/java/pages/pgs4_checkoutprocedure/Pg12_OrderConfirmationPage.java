package pages.pgs4_checkoutprocedure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pg12_OrderConfirmationPage {

    private WebDriver driver;
    private By orderCompleted = By.className("cheque-indent");


    public Pg12_OrderConfirmationPage(WebDriver driver){
        this.driver=driver;
    }

    public String getOrderConfirmationMessage(){
        return driver.findElement(orderCompleted).getText();
    }
}
