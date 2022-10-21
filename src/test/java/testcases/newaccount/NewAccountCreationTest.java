package testcases.newaccount;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import testdatautils.GettingPropertyData;


public class NewAccountCreationTest extends BaseTest {

    /**
     * The Account Creation Test Case Will be executed once per Email statically
     * If we want to make it Dynamic to overcome the User state
     * We can use the Java Faker to generate random data for our test but not recommended On real business testing
     * So For running this test case , we must change the email
     */


    @Test
    public void createNewAccountUsingThePropertyFile(){
        HomePage homePage = new HomePage(driver);
        String actualResult = homePage.load()
                .clickOnSignInButton()
                .createAccountEmailEntryStep(GettingPropertyData.getInstance().newEmail())
                .accountRegistration(GettingPropertyData.getInstance().firstName()
                        ,GettingPropertyData.getInstance().lastName()
                        ,GettingPropertyData.getInstance().password()
                        ,GettingPropertyData.getInstance().birthdateDay()
                        ,GettingPropertyData.getInstance().birthdateMonth()
                        ,GettingPropertyData.getInstance().birthdateYear()
                        ,GettingPropertyData.getInstance().address()
                        ,GettingPropertyData.getInstance().city()
                        ,GettingPropertyData.getInstance().state()
                        ,GettingPropertyData.getInstance().zipCode()
                        ,GettingPropertyData.getInstance().country()
                        ,GettingPropertyData.getInstance().mobilePhone())
                .clickOnRegisterButton()
                .getCurrentPageTitle();

        Assert.assertEquals(actualResult
                ,"My account - My Store"
                , "The actual result doesn't match the expected ");
    }


}
