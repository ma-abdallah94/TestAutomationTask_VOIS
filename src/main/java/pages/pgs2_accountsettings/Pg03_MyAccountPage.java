package pages.pgs2_accountsettings;

import org.openqa.selenium.WebDriver;

public class Pg03_MyAccountPage {
    private WebDriver driver;

    public Pg03_MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMyAccountPageTitle(){
        return driver.getTitle();
    }



}
