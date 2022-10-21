package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pgs0_home.Pg00_HomePage;
import testdatautils.GettingPropertyData;


public class TClass1_NewAccountCreationTest extends BaseTest {

    /**
     * The Account Creation Test Case Will be executed once per Email statically
     * If we want to make it Dynamic to overcome the User state
     * We can use the Java Faker to generate random data for our test but not recommended On real business testing
     * So For running the first test case , we must change the email.
     * The second test case is by Getting only random email address by Faker
     */


    // This test will run one time for each email entry
    @Test
    public void createNewAccountUsingThePropertyFile(){
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
                , "The actual result doesn't match the expected ");
    }


    // In this test I Only Changed the email , We can change other data entries with faker as we wish
    @Test
    public void createNewAccountUsingFakeEmailAddress(){
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
                , "The actual result doesn't match the expected ");
    }


}
