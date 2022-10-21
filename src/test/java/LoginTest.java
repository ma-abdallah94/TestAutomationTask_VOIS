import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pgs0_home.Pg00_HomePage;
import testdatautils.GettingPropertyData;

public class LoginTest extends BaseTest {

    @Test
    public void TestingLoginFunctionality(){
        Pg00_HomePage pg0HomePage = new Pg00_HomePage(driver);
        String actualResult = pg0HomePage.load()
                .clickOnHomePageSignInButton()
                .regularLogin(GettingPropertyData.existedEmail()
                        , GettingPropertyData.password())
                .clickOnAuthPageSignInButton()
                .getMyAccountPageTitle();

        Assert.assertEquals(actualResult
                ,"My account - My Store"
                , "The actual result doesn't match the expected ");
    }
}
