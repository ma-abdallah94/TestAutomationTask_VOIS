package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testdatautils.GettingPropertyData;

import java.time.Duration;

public class AuthenticationPage {

    private WebDriver driver ;
    private By emailCreationBox     = By.id("email_create");  // After insuring it's uniquely identified
    private By createAnAccountBtn   = By.id("SubmitCreate"); // Unique Id
    private By existedEmailLoginBox = By.id("email"); // Unique Id
    private By passwordBox          = By.id("passwd"); // Unique Id
    private By signInBtn            = By.id("SubmitLogin"); // Unique Id

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }



    public CreateAnAccountPage createAccountEmailEntryStep(String newEmail){
        setNewAccountEmail(newEmail);
        clickOnCreateAnAccountButton();
        return new CreateAnAccountPage(driver);
    }

    public MyAccountPage login (String existedEmail , String password ) {
        setExistedEmail(existedEmail);
        setPassword(password);
        clickOnSignInButton();
        return new MyAccountPage(driver);
    }




    public void setNewAccountEmail(String newEmail){
        driver.findElement(emailCreationBox).sendKeys(newEmail);
    }
    public void setExistedEmail(String existedEmail){
        driver.findElement(existedEmailLoginBox).sendKeys(existedEmail);
    }
    public void setPassword(String password){
        driver.findElement(passwordBox).sendKeys(password);
    }

    public MyAccountPage clickOnSignInButton(){
        driver.findElement(signInBtn).click();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15) );
        wait.until(ExpectedConditions.elementToBeClickable(signInBtn));

        return new MyAccountPage(driver);
    }
    public CreateAnAccountPage clickOnCreateAnAccountButton(){
        driver.findElement(createAnAccountBtn).click();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15) );
        wait.until(ExpectedConditions.elementToBeClickable(createAnAccountBtn));
        return new CreateAnAccountPage(driver);

    }

    public void loadAuthPage(){
        driver.get(GettingPropertyData.getInstance().baseURL()+"?controller=my-account");
    }

}
