package com.aditya.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExtentManager {
    private static ExtentReports extent;
    private static final String REPORT_DIR = "target/extent-report";
    private static final String REPORT_FILE = REPORT_DIR + "/extent-report.html";

    public synchronized static ExtentReports getExtentReports() {
        if (extent == null) {
            createReportDirectory();
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_FILE);
            sparkReporter.config().setDocumentTitle("Playwright Java Test Report");
            sparkReporter.config().setReportName("Playwright Java Extent Report");
            sparkReporter.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Framework", "Playwright Java");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }

    private static void createReportDirectory() {
        try {
            Path reportDirPath = Paths.get(REPORT_DIR);
            if (!Files.exists(reportDirPath)) {
                Files.createDirectories(reportDirPath);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to create Extent report directory", e);
        }
    }
}
