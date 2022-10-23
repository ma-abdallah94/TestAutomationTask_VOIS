package pages.pgs3_productselection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Pg05_BlousesPage {
    private WebDriver driver;
    private By blouseProductPriceBox = By.xpath("//a[@class=\"product-name\" and @title=\"Blouse\"]");

    public Pg05_BlousesPage(WebDriver driver) {
        this.driver= driver ;
    }

    public String getBlousesPageTitle(){
        return driver.getTitle();
    }

    public Pg06_BlousePreviewPage selectBlouseProduct(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(blouseProductPriceBox));
        driver.findElement(blouseProductPriceBox).click();
        return new Pg06_BlousePreviewPage(driver);
    }
}
