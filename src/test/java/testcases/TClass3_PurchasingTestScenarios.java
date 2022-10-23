package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pgs0_home.Pg00_HomePage;
import pages.pgs4_checkoutprocedure.Pg12_OrderConfirmationPage;
import testdatautils.GettingPropertyData;

/**
 * I created Some Low Level Test Cases To Validate Each Scenario Of The Task
 * tc08 > Is End-To-End Test Case Running From Scenario Number 1 To Number 6
 */

public class TClass3_PurchasingTestScenarios extends BaseTest {

    @Test (description = "This Test Method For Navigating To Women/Blouses Section ")
    public void tc3_NavigatingToBlousesInWomenSectionWhileLoggedOutTest(){
        Pg00_HomePage homePage = new Pg00_HomePage(driver);
        String actualResult = homePage.load()
                                      .selectingBlousesInWomenSection()
                                      .getBlousesPageTitle();

        Assert.assertEquals(actualResult
                ,"Blouses - My Store"
                , "The actual result doesn't match the expected ");
    }

    @Test (description = "This Test Method is For Validating The Blouse Selection")
    public void tc4_SelectingBlouseLoggedOutUserTest(){
        Pg00_HomePage homePage = new Pg00_HomePage(driver);

        boolean isItSelected = homePage.load()
                                        .selectingBlousesInWomenSection()
                                        .selectBlouseProduct()
                                        .blousePagePreviewLoaded();

        Assert.assertTrue( isItSelected , "There is a problem selecting the element ");
    }

    @Test (description = "This Test Method Is For Following The Checkout Procedure Only " )
    public void tc5_FollowingCheckoutProcedure(){
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

    @Test (description = "Confirming That The Purchase Process Is Completed " )
    public void tc6_ConfirmingOrderBySelectingBankWireOption(){
        Pg00_HomePage homePage = new Pg00_HomePage(driver);
        String actualResult =homePage.load()
                .selectingBlousesInWomenSection()
                .selectBlouseProduct()
                .clickOnAddToCartButtonFromBlousePreviewPage()
                .clickOnProceedToCheckoutLayerButton()
                .clickOnProceedToCheckoutButtonLoggedOutUserInShoppingCart()
                .login(GettingPropertyData.existedEmail()
                        ,GettingPropertyData.password())
                .clickSignInButtonForCheckoutProcedure()
                .clickOnProceedToCheckoutInAddressPage()
                .clickOnAgreementCheckBox()
                .clickOnProceedToCheckoutInShippingPage()
                .clickOnPayByBankWireOption()
                .clickOnIConfirmMyOrderButton()
                .getOrderConfirmationMessage();

        Assert.assertEquals(actualResult
                            ,"Your order on My Store is complete."
                            ,"Your Purchase Is not confirmed");
    }

    @Test (description = "Order Validating By Existing User ")
    public void tc7_ValidateOrderWasPlacedInOrderHistoryPage(){
        Pg00_HomePage homePage = new Pg00_HomePage(driver);
        String orderReferenceCodeInConfirmationPage =homePage.load()
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
                .printInnerHTMLToGetReferenceCodeFromConfirmationPage();

        Pg12_OrderConfirmationPage confirmationPage = new Pg12_OrderConfirmationPage(driver);
        String orderReferenceCodeInAccountHistoryPage = confirmationPage
                                            .clickOnMyAccountPage()
                                            .clickOnOrderHistoryDetailsTab()
                                            .gettingRequestedOrderText();
        Assert.assertEquals(
                 orderReferenceCodeInConfirmationPage
                ,orderReferenceCodeInAccountHistoryPage
                ,"The Order Is Not Here ");
    }

    @Test (description = "An End-To-End Test Starting From Home Page And Executing From 1 To 6 Task's Scenarios " )
    public void tc8_EndToEndUserCycleTest(){
        Pg00_HomePage homePage = new Pg00_HomePage(driver);
        String orderReferenceCodeInConfirmationPage =homePage.load()
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
                .selectingBlousesInWomenSection()
                .selectBlouseProduct()
                .clickOnAddToCartButtonFromBlousePreviewPage()
                .clickOnProceedToCheckoutLayerButton()
                .clickOnProceedToCheckoutButtonLoggedInUserInShoppingCart()
                .clickOnProceedToCheckoutInAddressPage()
                .clickOnAgreementCheckBox()
                .clickOnProceedToCheckoutInShippingPage()
                .clickOnPayByBankWireOption()
                .clickOnIConfirmMyOrderButton()
                .printInnerHTMLToGetReferenceCodeFromConfirmationPage();

        Pg12_OrderConfirmationPage confirmationPage = new Pg12_OrderConfirmationPage(driver);
        String orderReferenceCodeInAccountHistoryPage = confirmationPage
                .clickOnMyAccountPage()
                .clickOnOrderHistoryDetailsTab()
                .gettingRequestedOrderText();


        Assert.assertEquals(
                orderReferenceCodeInConfirmationPage
                ,orderReferenceCodeInAccountHistoryPage
                ,"The Order Is Not Here ");

    }

}
