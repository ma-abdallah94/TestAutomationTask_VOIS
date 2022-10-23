package pages.pgs2_accountsettings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Pg04_OrderHistoryPage {
    private WebDriver driver ;
    private By firstKnownOrderReferenceText = By.xpath("//tr[@class=\"first_item \"]//td[@class=\"history_link bold footable-first-column\"]//a");

    public Pg04_OrderHistoryPage(WebDriver driver) {
        this.driver=driver;
    }

    // The Function Retrieving the first element , the table is ordered ASC by default
    public String gettingRequestedOrderText(){
        return driver.findElement(firstKnownOrderReferenceText).getText();
    }
}