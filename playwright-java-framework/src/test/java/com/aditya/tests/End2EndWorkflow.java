package com.aditya.tests;
import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.*;
import com.aditya.pages.LoginPage;
import com.aditya.pages.ProductPage;
import com.aditya.pages.CheckoutPage;
import com.aditya.base.BaseTest;
import com.aditya.utils.ConfigReader;


public class End2EndWorkflow extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void initializePages() {
        page.navigate(ConfigReader.getProperty("base.url"));
        loginPage = new LoginPage(page);
        productPage = new ProductPage(page);
        checkoutPage = new CheckoutPage(page);
    }

    @Test
    public void endToEndWorkflow() {
        loginPage.login(
            ConfigReader.getProperty("username"),
            ConfigReader.getProperty("password")
        );
        productPage.addProductToCart("Sauce Labs Backpack");
        checkoutPage.checkout(
            ConfigReader.getProperty("first.name"),
            ConfigReader.getProperty("last.name"),
            ConfigReader.getProperty("postal.code")
        );
        Assert.assertEquals(checkoutPage.getConfirmationMessage(), "Thank you for your order!");
    }
}