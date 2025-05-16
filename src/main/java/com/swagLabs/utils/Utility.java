package com.swagLabs.utils;

import com.swagLabs.base.Base;
import com.swagLabs.pages.ProductPage;
import org.testng.Assert;

public class Utility extends Base {
    static ProductPage productPage=new ProductPage();

    public  static void logout() {
        productPage.logout();
        Assert.assertEquals(getDriver().getCurrentUrl(),properties.getProperty(LOGIN_URL));
    }
}
