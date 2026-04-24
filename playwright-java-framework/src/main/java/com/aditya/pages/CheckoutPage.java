package com.aditya.pages;

import com.microsoft.playwright.Page;

public class CheckoutPage {
    private Page page;

    public CheckoutPage(Page page) {
        this.page = page;
    }

    public void checkout(String firstName, String lastName, String postalCode) {
        page.click("button[id='checkout']");
        page.fill("#first-name", firstName);
        page.fill("#last-name", lastName);
        page.fill("#postal-code", postalCode);
        page.click("#continue");
        page.click("#finish");
    }

    public String getConfirmationMessage() {
        return page.textContent(".complete-header");
    }
}