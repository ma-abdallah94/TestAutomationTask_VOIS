import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pgs0_home.Pg00_HomePage;

public class PurchasingTest extends BaseTest {

    @Test
    public void navigatingToBlousesInWomenSectionWhileLoggedOutTest(){
        Pg00_HomePage pg0HomePage = new Pg00_HomePage(driver);
        String actualResult = pg0HomePage.load()
                                        .selectingBlousesInWomenSection()
                                        .getBlousesPageTitle();
        Assert.assertEquals(actualResult
                ,"Blouses - My Store"
                , "The actual result doesn't match the expected ");
    }

    @Test
    public void selectingBlouseLoggedOutUserTest(){
        Pg00_HomePage pg0HomePage = new Pg00_HomePage(driver);

        boolean isItSelected = pg0HomePage.load()
                                .selectingBlousesInWomenSection()
                                .selectBlouseProduct()
                                .blousePagePreviewLoaded();

        Assert.assertTrue( isItSelected , "There is a problem selecting the element ");
    }






}
