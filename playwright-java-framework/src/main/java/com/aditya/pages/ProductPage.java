package com.aditya.pages;

import com.aditya.utils.ObjectRepository;
import com.microsoft.playwright.Page;

public class ProductPage {
    private Page page;
    private final String cartLink = ObjectRepository.get("product.cartLink");

    public ProductPage(Page page) {
        this.page = page;
    }

    public void addProductToCart(String productName) {
        page.click(ObjectRepository.get("product.addButton", productName));
        page.click(cartLink);
    }
}