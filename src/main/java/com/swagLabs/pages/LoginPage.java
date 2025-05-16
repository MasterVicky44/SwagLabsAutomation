package com.swagLabs.pages;

import com.swagLabs.base.Base;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model for Cart Page.
 */

public class LoginPage extends Base {

    @FindBy(id="user-name")
    WebElement userNameElement;

    @FindBy(id="password")
    WebElement passwordElement;

    @FindBy(xpath="//input[@id='login-button']")
    WebElement loginButton;

    @FindBy(xpath="//div[@class='error-message-container error']")
    WebElement errorWebElement;

    public LoginPage(){
        PageFactory.initElements(getDriver(),this);
    }



    /**
     *
     * @param userName
     * @param password
     */
    public String login(String userName, String password){
       getDriver().navigate().refresh();
        // check if all element are present before performing the function.
        try {
            if(userNameElement.isDisplayed())
                userNameElement.sendKeys(userName);
            if(passwordElement.isDisplayed())
                passwordElement.sendKeys(password);
            if(loginButton.isDisplayed())
                loginButton.click();
        }catch (ElementNotInteractableException e){
            e.printStackTrace();
        }
        if(getDriver().getCurrentUrl().contains("inventory")) {
            return getDriver().getCurrentUrl();
        }
        else return errorWebElement.getText();
        }
}
