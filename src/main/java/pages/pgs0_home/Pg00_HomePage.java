package pages.pgs0_home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pgs1_authentications.Pg01_AuthenticationPage;
import pages.pgs3_productselection.Pg05_BlousesPage;
import testdatautils.GettingPropertyData;

import java.time.Duration;

public class Pg00_HomePage {

    private WebDriver driver ;
    private By signInBtn                = By.xpath("//a[@class=\"login\"]");
    private By headerWomenSection       = By.xpath("//a[@title=\"Women\"]");
    private By blousesInWomenSection    = By.xpath("//a[@title=\"Blouses\"]");

    public Pg00_HomePage(WebDriver driver) {
            this.driver=driver;
    }

    public Pg00_HomePage load(){
        driver.get(GettingPropertyData.getInstance().baseURL());
        return this;
    }

    public Pg01_AuthenticationPage clickOnHomePageSignInButton(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15) );
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInBtn));
        driver.findElement(signInBtn).click();
        return new Pg01_AuthenticationPage(driver);
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
