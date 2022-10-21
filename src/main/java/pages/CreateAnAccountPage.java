package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CreateAnAccountPage {
    private WebDriver driver ;
    private By mrRadioButton            = By.id("id_gender1"); //Unique ID
    private By firstNameInputBox        = By.xpath("//input[@id=\"customer_firstname\"]");
    private By lastNameInputBox         = By.cssSelector("#customer_lastname");
    private By passwordInputBox         = By.id("passwd");
    private By birthDayDropDownMenu     = By.id("days");
    private By birthMonthDropDownMenu   = By.id("months");
    private By birthYearDropDownMenu    = By.id("years");
    private By addressInputBox          = By.id("address1");
    private By cityInputBox             = By.id("city");
    private By stateDropDownMenu        = By.xpath("//select[@id=\"id_state\"]");
    private By zipCodeInputBox          = By.id("postcode");
    private By countryDropDownMenu      = By.xpath("//select[@id=\"id_country\"]");
    private By mobilePhoneInputBox      = By.cssSelector("#phone_mobile");
    private By registerButton           = By.id("submitAccount");

    public CreateAnAccountPage(WebDriver driver) {
        this.driver=driver;
    }


    public CreateAnAccountPage accountRegistration(String firstName , String lastName , String password , String birthDay
            , String birthMonth , String birthYear , String address , String cityName , String stateName
            ,String zipCode , String countryName , String mobilePhoneNumber ){
        clickOnMrGenderRadioButton();
        setFirstNameInput(firstName);
        setLastNameInput(lastName);
        setPassword(password);
        birthDaySelection(birthDay);
        birthMonthSelection(birthMonth);
        birthYearSelection(birthYear);
        setAddress(address);
        setCityName(cityName);
        stateSelection(stateName);
        zipCodeInput(zipCode);
        countrySelection(countryName);
        setMobilePhoneNumber(mobilePhoneNumber);
        return this;
    }

    public void clickOnMrGenderRadioButton(){
        driver.findElement(mrRadioButton).click();
    }
    public void setFirstNameInput(String firstName){
        driver.findElement(firstNameInputBox).sendKeys(firstName);
    }
    public void setLastNameInput(String lastName){
        driver.findElement(lastNameInputBox).sendKeys(lastName);
    }
    public void setPassword(String password){
        driver.findElement(passwordInputBox).sendKeys(password);
    }
    public void birthDaySelection(String birthDay){
        WebElement dayOfBirthElement = driver.findElement(birthDayDropDownMenu);
        Select selectDay = new Select(dayOfBirthElement);
        selectDay.selectByValue(birthDay);
    }
    public void birthMonthSelection(String birthMonth){
        WebElement monthOfBirthElement = driver.findElement(birthMonthDropDownMenu);
        Select selectMonth = new Select(monthOfBirthElement);
        selectMonth.selectByValue(birthMonth);
    }
    public void birthYearSelection(String birthYear){
        WebElement yearOfBirthElement = driver.findElement(birthYearDropDownMenu);
        Select selectYear = new Select(yearOfBirthElement);
        selectYear.selectByValue(birthYear);
    }
    public void setAddress(String address){
        driver.findElement(addressInputBox).sendKeys(address);
    }
    public void setCityName(String cityName){
        driver.findElement(cityInputBox).sendKeys(cityName);
    }
    public void stateSelection(String stateName){
        WebElement stateElement = driver.findElement(stateDropDownMenu);
        Select selectState = new Select(stateElement);
        selectState.selectByVisibleText(stateName);
    }
    public void zipCodeInput(String zipCode){
        driver.findElement(zipCodeInputBox).sendKeys(zipCode);
    }
    public void countrySelection(String countryName){
        WebElement countryElement = driver.findElement(countryDropDownMenu);
        Select selectCountry = new Select(countryElement);
        selectCountry.selectByVisibleText(countryName);
    }
    public void setMobilePhoneNumber(String mobilePhoneNumber){
        driver.findElement(mobilePhoneInputBox).sendKeys(mobilePhoneNumber);
    }

    public MyAccountPage clickOnRegisterButton(){
        driver.findElement(registerButton).click();
        return new MyAccountPage(driver);
    }



}
