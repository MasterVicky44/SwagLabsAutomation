package com.swagLabs.pages;

import com.swagLabs.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model for Checkout Page.
 */

public class CheckoutPage extends Base {

    //Constructor to assign Page WebElements
    public CheckoutPage() {
        PageFactory.initElements(getDriver(), this);
    }

    // Customer Information Locators
    @FindBy(id = "first-name")
    WebElement firstNameInput;

    @FindBy(id = "last-name")
    WebElement lastNameInput;

    @FindBy(id = "postal-code")
    WebElement zipCodeInput;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(css = "h3[data-test='error']")
    WebElement errorMessage;

    // Overview Page
    @FindBy(id = "finish")
    WebElement finishButton;

    @FindBy(className = "complete-header")
    WebElement confirmationMessage;

    // Actions
    public void fillCustomerInfo(String firstName, String lastName, String zip) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        zipCodeInput.sendKeys(zip);
        continueButton.click();
    }

    public void finishCheckout() {
        finishButton.click();
    }

    public String getConfirmationText() {
        return confirmationMessage.getText();
    }

    public String getErrorText() {
        return errorMessage.getText();
    }
}

