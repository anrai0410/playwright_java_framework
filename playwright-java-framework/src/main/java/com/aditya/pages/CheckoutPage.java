package com.aditya.pages;

import com.aditya.utils.ObjectRepository;
import com.microsoft.playwright.Page;

public class CheckoutPage {
    private Page page;
    private final String checkoutButton = ObjectRepository.get("checkout.checkoutButton");
    private final String firstName = ObjectRepository.get("checkout.firstName");
    private final String lastName = ObjectRepository.get("checkout.lastName");
    private final String postalCode = ObjectRepository.get("checkout.postalCode");
    private final String continueButton = ObjectRepository.get("checkout.continueButton");
    private final String finishButton = ObjectRepository.get("checkout.finishButton");
    private final String confirmationMessage = ObjectRepository.get("checkout.confirmationMessage");

    public CheckoutPage(Page page) {
        this.page = page;
    }

    public void checkout(String firstName, String lastName, String postalCode) {
        page.click(checkoutButton);
        page.fill(this.firstName, firstName);
        page.fill(this.lastName, lastName);
        page.fill(this.postalCode, postalCode);
        page.click(continueButton);
        page.click(finishButton);
    }

    public String getConfirmationMessage() {
        return page.textContent(confirmationMessage);
    }
}