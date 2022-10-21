package pages.pgs2_accountsettings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pgs4_checkoutprocedure.Pg10_PaymentMethodPage;

import java.time.Duration;

public class Pg03_MyAccountPage {
    private WebDriver driver;
    private By orderHistoryAndDetailsBtn = By.xpath("//a[@title=\"Orders\"]");

    public Pg03_MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMyAccountPageTitle(){
        return driver.getTitle();
    }

    public Pg04_OrderHistoryPage clickOnOrderHistoryDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderHistoryAndDetailsBtn));
        driver.findElement(orderHistoryAndDetailsBtn).click();
        return new Pg04_OrderHistoryPage (driver);
    }

}
