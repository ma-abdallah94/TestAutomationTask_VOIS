package pages.pgs2_accountsettings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pgs3_productselection.Pg05_BlousesPage;
import java.time.Duration;


public class Pg03_MyAccountPage  {
    private  WebDriver driver;
    private By orderHistoryAndDetailsBtn    = By.xpath("//a[@title=\"Orders\"]");
    private By headerWomenSection           = By.xpath("//a[@title=\"Women\"]");
    private By blousesInWomenSection        = By.xpath("//a[@title=\"Blouses\"]");

    public Pg03_MyAccountPage(WebDriver driver) {
        this.driver=driver;
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

    public Pg05_BlousesPage selectingBlousesInWomenSection(){
        WebElement womenSectionElement = driver.findElement(headerWomenSection);
        Actions actions = new Actions(driver);
        actions.moveToElement(womenSectionElement).perform();

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(blousesInWomenSection));

        driver.findElement(blousesInWomenSection).click();

        return new Pg05_BlousesPage(driver);
    }

}
