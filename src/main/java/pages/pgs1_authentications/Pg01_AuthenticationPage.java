package pages.pgs1_authentications;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pgs4_checkoutprocedure.Pg08_DeliveryAddressPage;
import pages.pgs2_accountsettings.Pg03_MyAccountPage;
import testdatautils.GettingPropertyData;

import java.time.Duration;

public class Pg01_AuthenticationPage {

    private WebDriver driver ;
    private By emailCreationBox         = By.id("email_create");  // After insuring it's uniquely identified
    private By createAnAccountBtn       = By.id("SubmitCreate"); // Unique Id
    private By existedEmailLoginBox     = By.id("email"); // Unique Id
    private By passwordBox              = By.id("passwd"); // Unique Id
    private By signInBtn                = By.id("SubmitLogin"); // Unique Id

    public Pg01_AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public Pg02_CreateAnAccountPage createAccountEmailEntryStep(String newEmail){
        setNewAccountEmail(newEmail);
        clickOnCreateAnAccountButton();
        return new Pg02_CreateAnAccountPage(driver);
    }
    public Pg02_CreateAnAccountPage clickOnCreateAnAccountButton(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15) );
        wait.until(ExpectedConditions.visibilityOfElementLocated(createAnAccountBtn));

        driver.findElement(createAnAccountBtn).click();
        return new Pg02_CreateAnAccountPage(driver);
    }
    public Pg02_CreateAnAccountPage createAccountUsingFakeEmail(){
        fakeEmailUsingFaker(Faker.instance().internet().emailAddress());
        clickOnCreateAnAccountButton();
        return new Pg02_CreateAnAccountPage(driver);
    }

    public Pg01_AuthenticationPage login(String existedEmail , String password ) {
        setExistedEmail(existedEmail);
        setPassword(password);
        return this;
    }
    public Pg03_MyAccountPage clickOnAuthPageSignInButton(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15) );
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInBtn));

        driver.findElement(signInBtn).click();
        return new Pg03_MyAccountPage(driver);
    }

    public Pg08_DeliveryAddressPage clickSignInButtonForCheckoutProcedure(){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15) );
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInBtn));

        driver.findElement(signInBtn).click();
        return new Pg08_DeliveryAddressPage(driver);
    }

    public void setNewAccountEmail(String newEmail){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15) );
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailCreationBox));
        driver.findElement(emailCreationBox).sendKeys(newEmail);
    }
    public void setExistedEmail(String existedEmail){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15) );
        wait.until(ExpectedConditions.visibilityOfElementLocated(existedEmailLoginBox));
        driver.findElement(existedEmailLoginBox).sendKeys(existedEmail);
    }
    public void setPassword(String password){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15) );
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordBox));
        driver.findElement(passwordBox).sendKeys(password);
    }

    public void fakeEmailUsingFaker(String fakeEmail){
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(15) );
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailCreationBox));
        driver.findElement(emailCreationBox).sendKeys(fakeEmail);
    }

    //I was Using this function in testing and shortcut some pages
    public Pg01_AuthenticationPage loadAuthPage(){
        driver.get(GettingPropertyData.getInstance().baseURL()+"?controller=my-account");
        return this;
    }
}
