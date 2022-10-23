package pages.pgs4_checkoutprocedure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.pgs2_accountsettings.Pg03_MyAccountPage;

public class Pg12_OrderConfirmationPage {

    private WebDriver driver;
    private By orderCompleted      = By.className("cheque-indent");
    private By myAccountPageBtn    = By.xpath("//a[@class=\"account\"]");

    public Pg12_OrderConfirmationPage(WebDriver driver){
        this.driver=driver;
    }


    //The Completion of order message
    public String getOrderConfirmationMessage(){
        return driver.findElement(orderCompleted).getText();
    }

    /*Because Selenium cannot see or interaction with <br> elements in the DOM , I found a solution on stackoverflow
     This solution helped me to extract the order reference code to Assert and Validate the Order
     Link to this solution : https://stackoverflow.com/questions/63649002/text-content-located-in-second-br-tag-cant-be-printed */
    public String printInnerHTMLToGetReferenceCodeFromConfirmationPage(){
        WebElement referenceVanished = driver.findElement(By.xpath("//*[text()[contains(.,'- Do not forget to insert your order reference')]]"));
        String[] myTextArray = referenceVanished.getAttribute("innerHTML").split("<br>");
        String[] referenceCodeInOrderConfirmation = myTextArray[5].split(" ");
       return referenceCodeInOrderConfirmation[9];
    }

    //clicking will navigate to the MyAccountPage
    public Pg03_MyAccountPage clickOnMyAccountPage(){
        driver.findElement(myAccountPageBtn).click();
        return new Pg03_MyAccountPage(driver);
    }



    /* These were my attempts to find the <br> Element ,
     after searching I've found out that <br> elements cannot be reached by selenium

    // private By strongToUseToLocateBrBelowit = By.xpath("//strong[normalize-space()='RTP']");
    //div[@class='box']//strong[text()="RTP"]/following-sibling::br[1]
    //div[@class="box"]/text()[11]
    //div[@id='center_column']//text()[11]
    //*[@id="center_column"]/div/text()[6]
    //*[text()[contains(.,'- Do not forget to insert your order reference EMQCSWOWF in the subject of your bank wire.')]]
    //strong[normalize-space()='RTP']
    */

   // I was trying to fetch and locate the reference code in this page multiple ways

    /*
        public String confirmationPageReferenceCodeText(){
        WebElement rtpStrong = driver.findElement(strongToUseToLocateBrBelowit);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(strongToUseToLocateBrBelowit));


        String[] referenceCode= driver.findElement(RelativeLocator.with(By.xpath("//div[@class=\"box\"]/text()[11]")).below(rtpStrong))
                .getText().split(" ");
        return referenceCode[9];
    }*/




}
