package com.aditya.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;
    private String usernameInput = "#user-name";
    private String passwordInput = "#password";
    private String loginButton = "#login-button";

    public LoginPage(Page page) { this.page = page; }

    public void navigate(String url) { page.navigate(url); }

    public void login(String user, String pass) {
        page.fill(usernameInput, user);
        page.fill(passwordInput, pass);
        page.click(loginButton);
    }
}