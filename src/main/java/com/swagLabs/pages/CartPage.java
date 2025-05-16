package com.swagLabs.pages;

import com.swagLabs.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model for Cart Page.
 */
public class CartPage extends Base {


    // Constructor
    public CartPage() {

        PageFactory.initElements(getDriver(), this);
    }

    // Locators
    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingButton;

    // Actions
    public void clickCheckout() {
        checkoutButton.click();
    }

    public void clickContinueShopping() {
        continueShoppingButton.click();
    }
}
