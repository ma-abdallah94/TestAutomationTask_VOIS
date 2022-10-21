package pages.pgs2_accountsettings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pg04_OrderHistoryPage {
    private WebDriver driver ;
    private By knownOrderReferenceText = By.xpath("//a[contains (text(),\"FEMUXEUYE\")]");

    public Pg04_OrderHistoryPage(WebDriver driver) {
        this.driver=driver;
    }


}
