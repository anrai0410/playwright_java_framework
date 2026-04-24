package com.aditya.pages;

import com.microsoft.playwright.Page;

public class ProductPage {
    private Page page;

    public ProductPage(Page page) {
        this.page = page;
    }

    public void addProductToCart(String productName) {
        // Add the product using the item card button; avoid clicking the title link.
        page.click("div.inventory_item:has-text('" + productName + "') button.btn_inventory");
        page.click(".shopping_cart_link");
    }
}