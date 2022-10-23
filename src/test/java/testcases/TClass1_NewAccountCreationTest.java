package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pgs0_home.Pg00_HomePage;
import testdatautils.GettingPropertyData;


public class TClass1_NewAccountCreationTest extends BaseTest {

    /**
     * The First Account Creation Test  "TC0" Will be executed once per Email statically derived from TestData.properties
     * If we want to make it Dynamic to overcome the User state
     * We can use the Java Faker to generate random data for our test but not recommended On real business testing
     * So For running the first test case , we must change the email.
     * The second test case "TC1" is by Getting only random email address by Faker ( Only Email For The Current Test )
     */


    // This test will run one time for each email entry
    @Test (description = "This Test Is To Validate Account Creation Using Property File " )
    public void TC0_CreateNewAccountUsingPropertyEmail(){
        Pg00_HomePage pg0HomePage = new Pg00_HomePage(driver);
        String actualResult = pg0HomePage.load()
                .clickOnHomePageSignInButton()
                .createAccountEmailEntryStep(GettingPropertyData.newEmail())
                .accountRegistration
                                (GettingPropertyData.firstName()
                                ,GettingPropertyData.lastName()
                                ,GettingPropertyData.password()
                                ,GettingPropertyData.birthdateDay()
                                ,GettingPropertyData.birthdateMonth()
                                ,GettingPropertyData.birthdateYear()
                                ,GettingPropertyData.address()
                                ,GettingPropertyData.city()
                                ,GettingPropertyData.state()
                                ,GettingPropertyData.zipCode()
                                ,GettingPropertyData.country()
                                ,GettingPropertyData.mobilePhone())
                .clickOnRegisterButton()
                .getMyAccountPageTitle();

        Assert.assertEquals(actualResult
                ,"My account - My Store"
                , "The Account Is Not Created ");
    }


    // In this test I Only Changed the email , We can change other data entries with faker as we wish
    @Test (description = "This Test Is To Validate Account Creation Using Fake Email Address Using JavaFaker ")
    public void TC1_CreateNewAccountUsingFakeEmailAddress(){
        Pg00_HomePage pg0HomePage = new Pg00_HomePage(driver);
        String actualResult = pg0HomePage.load()
                .clickOnHomePageSignInButton()
                .createAccountUsingFakeEmail()
                .accountRegistration
                        (GettingPropertyData.firstName()
                        ,GettingPropertyData.lastName()
                        ,GettingPropertyData.password()
                        ,GettingPropertyData.birthdateDay()
                        ,GettingPropertyData.birthdateMonth()
                        ,GettingPropertyData.birthdateYear()
                        ,GettingPropertyData.address()
                        ,GettingPropertyData.city()
                        ,GettingPropertyData.state()
                        ,GettingPropertyData.zipCode()
                        ,GettingPropertyData.country()
                        ,GettingPropertyData.mobilePhone())
                .clickOnRegisterButton()
                .getMyAccountPageTitle();

        Assert.assertEquals(actualResult
                ,"My account - My Store"
                , "The Account Is Not Created ");
    }


}
