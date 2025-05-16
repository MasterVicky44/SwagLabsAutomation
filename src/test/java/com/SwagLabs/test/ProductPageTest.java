package com.SwagLabs.test;

import com.swagLabs.base.Base;
import com.swagLabs.pages.LoginPage;
import com.swagLabs.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.*;


public class ProductPageTest extends Base {

    ProductPage productPage;
    LoginPage loginPage;

    ProductPageTest(){
        super();
    }

    @BeforeClass
    public void setUp(){
        startBrowser(CHROME);
        productPage = new ProductPage();
        loginPage=new LoginPage();
    }

    @BeforeMethod
    public void login() {
        goToLoginPage();
        loginPage.login(properties.getProperty(VALID_USER),properties.getProperty(PASSWORD));
    }

    @Test(priority = 1, description = "Test case to check user is able to add product and cart count is showing 1")
    public void addProductToCart() {
        productPage.clickAddFirstProduct();
        Assert.assertEquals(productPage.getCartItemCount(), "1");
        productPage.clickRemoveFirstProduct();
    }

    @Test(priority = 2,description = "Test case to when user adds and remove the item, cart count is showing 0")
    public void removeProductFromCart() {
        productPage.clickAddFirstProduct();
        productPage.clickRemoveFirstProduct();
        Assert.assertEquals(productPage.getCartItemCount(), "0");
    }

    @Test(priority = 3, description = "Test case to check Cart Persists After Navigation")
    public void cartCountPersistsAfterRefresh() {
        productPage.clickAddFirstProduct();
        getDriver().navigate().refresh();
        Assert.assertEquals(productPage.getCartItemCount(), "1");
    }

    @AfterMethod
    public void cleanUpAfterEachTest() {
        if (getDriver().getCurrentUrl().contains("inventory.html")) {
            productPage.logout();
        }
    }

    @AfterClass
    public void closeBrowser()
    {
        tearDown();
    }
}
