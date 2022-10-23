package pages.pgs3_productselection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pgs4_checkoutprocedure.Pg07_ShoppingCartPage;

import java.time.Duration;

public class Pg06_BlousePreviewPage {
    private WebDriver driver ;
    private By dataSheetText            = By.xpath("//h3[@class=\"page-product-heading\" and text()=\"Data sheet\"]");
    private By addToCartButton          = By.xpath("//span[text()=\"Add to cart\"]");
    private By proceedToCheckOutBtnLyr  = By.xpath("//a[@title=\"Proceed to checkout\"]");

    public Pg06_BlousePreviewPage(WebDriver driver) {
        this.driver=driver ;
    }
    public boolean blousePagePreviewLoaded() {
        return driver.findElement(dataSheetText).isDisplayed();
    }

    public Pg06_BlousePreviewPage clickOnAddToCartButtonFromBlousePreviewPage(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        driver.findElement(addToCartButton).click();
        return this;
    }
    public Pg07_ShoppingCartPage clickOnProceedToCheckoutLayerButton(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckOutBtnLyr));
        driver.findElement(proceedToCheckOutBtnLyr).click();
        return new Pg07_ShoppingCartPage(driver);
    }
}
