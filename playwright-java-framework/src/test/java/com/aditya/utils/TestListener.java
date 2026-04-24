package com.aditya.utils;

import com.microsoft.playwright.Page;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        try {
            // Try to get the page from the test instance
            Page page = (Page) testClass.getClass().getField("page").get(testClass);
            if (page != null) {
                String screenshotPath = "target/screenshots/" + result.getName() + "_" + System.currentTimeMillis() + ".png";
                page.screenshot(new Page.ScreenshotOptions().setPath(java.nio.file.Paths.get(screenshotPath)));
                System.out.println("Screenshot captured: " + screenshotPath);
            }
        } catch (Exception e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}