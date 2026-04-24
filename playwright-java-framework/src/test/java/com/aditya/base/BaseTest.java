package com.aditya.base;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.aditya.utils.ConfigReader;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeMethod
    public void setUp() {
        playwright = Playwright.create();
        String browserName = ConfigReader.getProperty("browser", "chromium");
        boolean headless = ConfigReader.getBooleanProperty("headless");

        BrowserType browserType;
        switch (browserName.toLowerCase()) {
            case "firefox":
                browserType = playwright.firefox();
                break;
            case "webkit":
                browserType = playwright.webkit();
                break;
            default:
                browserType = playwright.chromium();
        }

        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless));
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterMethod
    public void tearDown() {
        if (context != null) {
            context.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}