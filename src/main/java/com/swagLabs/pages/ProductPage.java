package com.swagLabs.pages;

import com.swagLabs.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductPage extends Base {

    @FindBy(xpath = "(//button[contains(text(),'Remove')])[1]")
    public WebElement firstRemoveButton;

    @FindBy(xpath = "(//button[contains(text(),'Add to cart')])[1]")
    public WebElement firstAddToCartButton;

    @FindBy(xpath = "//*[@id='shopping_cart_container']/a")
    public WebElement cartIcon;

    @FindBy(className = "shopping_cart_badge")
    public WebElement cartBadge;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutLink;


    public ProductPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public void clickAddFirstProduct() {
        firstAddToCartButton.click();
    }

    public void clickRemoveFirstProduct() {
        firstRemoveButton.click();
    }

    public String getCartItemCount() {
        try {
            return cartBadge.getText();
        } catch (Exception e) {
            return "0";
        }
    }

    public void goToCart() {
        cartIcon.click();
    }

    public void logout() {
        menuButton.click();
        try {
            Thread.sleep(500); // wait for menu animation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logoutLink.click();
    }
}






