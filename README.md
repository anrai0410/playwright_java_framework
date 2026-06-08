# playwright_java_framework

## Project Overview

This repository contains a Java-based Playwright automation framework implemented with Maven and TestNG. It executes an end-to-end workflow on the Sauce Demo site and generates an HTML report using ExtentReports.

## What It Covers

The framework automates the following user flow:
- Navigate to the login page
- Authenticate with valid credentials
- Add a product to the shopping cart
- Proceed through checkout
- Verify the order completion message

## Technology Stack

- ☕ Java 11
- 📦 Maven
- 🎭 Playwright Java
- 🧪 TestNG
- 📊 ExtentReports

## Repository Structure

- `pom.xml` — Maven configuration and project dependencies
- `testng.xml` — TestNG suite and listener configuration
- `src/main/java/com/aditya/base/BaseTest.java` — Browser setup, Playwright initialization, and teardown
- `src/main/java/com/aditya/pages` — Page Object Model classes:
  - `LoginPage.java`
  - `ProductPage.java`
  - `CheckoutPage.java`
- `src/main/java/com/aditya/utils` — Utility classes:
  - `ConfigReader.java` — loads test configuration values
  - `ObjectRepository.java` — centralized locator repository
  - `ExtentManager.java` — ExtentReports initialization
  - `TestListener.java` — TestNG listener for logging and screenshot support
- `src/main/resources/config.properties` — runtime settings such as URL, browser, and credentials
- `src/main/resources/object-repository.properties` — centralized CSS selectors and element locators
- `src/test/java/com/aditya/tests/End2EndWorkflow.java` — main TestNG test executing the full positive path

## Key Features

- Centralized page objects using the Page Object Model
- Object repository for selectors and locators
- Playwright browser automation with headless support
- ExtentReports HTML reporting
- TestNG listener integration for test lifecycle events

## Configuration

The framework loads values from `src/main/resources/config.properties`. Common settings include:
- `app.url` — application base URL
- `browser` — browser type used by Playwright
- `username` and `password` — login credentials
- `headless` — whether the browser runs in headless mode

Selectors are defined in `src/main/resources/object-repository.properties` and referenced via `ObjectRepository.get(...)` from page classes.

## How to Run

From the repository root, execute:

```bash
cd playwright-java-framework
mvn test
```

This command runs the TestNG suite defined in `testng.xml` and executes the end-to-end workflow.

## Report Output

After the run, the ExtentReports HTML report is generated at:

- `playwright-java-framework/target/extent-report/extent-report.html`

Open this file in a browser to review the test report.

## How to Extend the Framework

To add new tests or extend the framework:
- Add page objects under `src/main/java/com/aditya/pages`.
- Store selectors in `src/main/resources/object-repository.properties` and retrieve them with `ObjectRepository.get(...)`.
- Create new test classes under `src/test/java/com/aditya/tests` and add them to `testng.xml` or use TestNG annotations.
- Use `BaseTest` for browser setup/teardown and share Playwright page state across tests.
- Keep configuration values in `config.properties` for easy environment updates.

## Notes

- The current Maven build is configured for Java 11 with `<maven.compiler.release>11</maven.compiler.release>`.
- A harmless SLF4J warning may appear during execution if no logger implementation is present, but it does not affect test execution.

## Running the Whole Project

The framework is ready to run end-to-end using `mvn test`. The complete project has been verified successfully and the current execution status is:
- `BUILD SUCCESS`
- `1 test run`
- `0 failures`
- `0 errors`
- `0 skipped`
