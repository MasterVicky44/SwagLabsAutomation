package com.SwagLabs.test;

import com.swagLabs.base.Base;
import com.swagLabs.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CheckoutPageTest extends Base {
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    CheckoutPageTest(){
        super();
    }

    @BeforeClass
    public void setUp(){
        startBrowser(CHROME);
        loginPage = new LoginPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
    }


    public void gotoCheckOut(){
        goToLoginPage();
        loginPage.login(properties.getProperty(VALID_USER),properties.getProperty(PASSWORD));
        productPage.clickAddFirstProduct(); // Assumes first product
        productPage.goToCart();             // Navigates to cart
        cartPage.clickCheckout();           // Proceeds to checkout

    }
    @Test()
    public void testSuccessfulCheckout() {
        gotoCheckOut();         // Proceeds to checkout

        // Fill checkout form with mock data
        checkoutPage.fillCustomerInfo(FIRSTNAME,LASTNAME,PIN);

        // Finish the checkout
        checkoutPage.finishCheckout();

        // Validate confirmation screen
        Assert.assertEquals(checkoutPage.getConfirmationText(),ORDER_CONFIRMATION_MESSAGE);
    }

    @Test
    public void testCheckoutWithEmptyFieldsShowsError() {
        gotoCheckOut();
        // Leave fields empty
        checkoutPage.fillCustomerInfo("", "", "");

        String error = checkoutPage.getErrorText();
        Assert.assertTrue(error.contains("Error"), "Error: First Name is required");
    }

}
