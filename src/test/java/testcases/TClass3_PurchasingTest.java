package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pgs0_home.Pg00_HomePage;
import testdatautils.GettingPropertyData;

public class TClass3_PurchasingTest extends BaseTest {

    @Test
    public void navigatingToBlousesInWomenSectionWhileLoggedOutTest(){
        Pg00_HomePage homePage = new Pg00_HomePage(driver);
        String actualResult = homePage.load()
                                      .selectingBlousesInWomenSection()
                                      .getBlousesPageTitle();

        Assert.assertEquals(actualResult
                ,"Blouses - My Store"
                , "The actual result doesn't match the expected ");
    }

    @Test
    public void selectingBlouseLoggedOutUserTest(){
        Pg00_HomePage homePage = new Pg00_HomePage(driver);

        boolean isItSelected = homePage.load()
                                        .selectingBlousesInWomenSection()
                                        .selectBlouseProduct()
                                        .blousePagePreviewLoaded();

        Assert.assertTrue( isItSelected , "There is a problem selecting the element ");
    }

    @Test
    public void followingCheckoutProcedure(){
        Pg00_HomePage homePage = new Pg00_HomePage(driver);
        homePage.load()
                .selectingBlousesInWomenSection()
                .selectBlouseProduct()
                .clickOnAddToCartButtonFromBlousePreviewPage()
                .clickOnProceedToCheckoutLayerButton()
                .clickOnProceedToCheckoutButtonLoggedOutUserInShoppingCart()
                .login(GettingPropertyData.existedEmail(),GettingPropertyData.password())
                .clickSignInButtonForCheckoutProcedure()
                .clickOnProceedToCheckoutInAddressPage()
                .clickOnAgreementCheckBox()
                .clickOnProceedToCheckoutInShippingPage();
    }

    @Test
    public void confirmingOrderBySelectingBankWireOption(){
        Pg00_HomePage homePage = new Pg00_HomePage(driver);
        String actualResult =homePage.load()
                .selectingBlousesInWomenSection()
                .selectBlouseProduct()
                .clickOnAddToCartButtonFromBlousePreviewPage()
                .clickOnProceedToCheckoutLayerButton()
                .clickOnProceedToCheckoutButtonLoggedOutUserInShoppingCart()
                .login(GettingPropertyData.existedEmail(),GettingPropertyData.password())
                .clickSignInButtonForCheckoutProcedure()
                .clickOnProceedToCheckoutInAddressPage()
                .clickOnAgreementCheckBox()
                .clickOnProceedToCheckoutInShippingPage()
                .clickOnPayByBankWireOption()
                .clickOnIConfirmMyOrderButton()
                .getOrderConfirmationMessage();

        Assert.assertEquals(actualResult
                            ,"Your order on My Store is complete."
                            ,"Test Not Matched");

    }



}
