package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pgs0_home.Pg00_HomePage;
import testdatautils.GettingPropertyData;

public class TClass2_LoginTest extends BaseTest {

    // This Test to use the registered account
    @Test
    public void tc2_TestingLoginFunctionality(){
        Pg00_HomePage pg0HomePage = new Pg00_HomePage(driver);
        String actualResult = pg0HomePage.load()
                .clickOnHomePageSignInButton()
                .login(  GettingPropertyData.existedEmail()
                        ,GettingPropertyData.password())
                .clickOnAuthPageSignInButton()
                .getMyAccountPageTitle();

        Assert.assertEquals(actualResult
                ,"My account - My Store"
                , "The actual result doesn't match the expected ");
    }
}
