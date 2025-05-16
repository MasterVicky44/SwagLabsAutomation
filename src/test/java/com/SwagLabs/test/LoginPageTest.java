package com.SwagLabs.test;

import com.swagLabs.base.Base;
import com.swagLabs.pages.LoginPage;
import com.swagLabs.utils.Utility;
import org.testng.Assert;
import org.testng.annotations.*;


public class LoginPageTest extends Base {

    LoginPage loginPage;

    // initialize the Super Class before setup
    LoginPageTest(){
        super();
    }

    @BeforeClass
    public void setUp(){
        startBrowser(CHROME);
        goToLoginPage();
        loginPage=new LoginPage();
    }

    //RetryAnalyzer + Screenshot
    @Test( priority = 2, description = "Test case intentionally failing to checkRetryLogic and ScreenShot feature")
    public void testCaseToCheckRetryAndScreenshot(){
        goToLoginPage();
        String currentURL=loginPage.login(INVALID_USER,properties.getProperty(PASSWORD)) ;
        Assert.assertEquals(currentURL,properties.get(PRODUCT_URL));
    }

    @Test(priority = 1, description = "Test case to check Login  when username and password is correct")
    public void validateValidUserLogin(){
        String currentURL=loginPage.login(properties.getProperty(VALID_USER),properties.getProperty(PASSWORD)) ;
        Assert.assertEquals(currentURL,properties.get(PRODUCT_URL));
        Utility.logout();
    }


    @Test(description = "Test case to check Login with Locked Out User")
    public void validateLockedUserLogin(){
        String message=loginPage.login(LOCKED_OUT_USER,properties.getProperty(PASSWORD)) ;
        Assert.assertEquals(message,LOCKED_OUT_ERROR_MESSAGE);
    }

    @Test(description = "Test case to check Login with Invalid_Username ")
    public void loginWithInvalidUsername(){
        String message=loginPage.login(INVALID_USER,properties.getProperty(PASSWORD)) ;
        Assert.assertEquals(message,INVALID_ERROR_MESSAGE);
    }

    @Test(description = "Test case to check Login with Invalid Password")
    public void loginWithInvalidPassword(){
        String message=loginPage.login(properties.getProperty(VALID_USER),PASSWORD) ;
        Assert.assertEquals(message,INVALID_ERROR_MESSAGE);
    }

    @Test(description = "Test case to check Login with Empty Username")
    public void loginWithEmptyUserName(){
        String message=loginPage.login(EMPTY_USERNAME, EMPTY_PASSWORD) ;
        Assert.assertEquals(message,BLANK_USERNAME_ERROR_MESSAGE);
    }

    @Test(description = "Test case to check Login with Empty Password")
    public void loginWithEmptyPassword(){
        String message=loginPage.login(VALID_USER,EMPTY_PASSWORD) ;
        Assert.assertEquals(message,BLANK_PASSWORD_ERROR_MESSAGE);
    }

    @AfterClass
    public void closeBrowser(){
        tearDown();
    }

}
