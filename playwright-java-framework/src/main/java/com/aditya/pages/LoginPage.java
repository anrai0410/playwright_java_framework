package com.aditya.pages;

import com.aditya.utils.ObjectRepository;
import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;
    private final String usernameInput = ObjectRepository.get("login.usernameInput");
    private final String passwordInput = ObjectRepository.get("login.passwordInput");
    private final String loginButton = ObjectRepository.get("login.loginButton");

    public LoginPage(Page page) { this.page = page; }

    public void navigate(String url) { page.navigate(url); }

    public void login(String user, String pass) {
        page.fill(usernameInput, user);
        page.fill(passwordInput, pass);
        page.click(loginButton);
    }
}