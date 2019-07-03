package com.applitools.quickstarts;

import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.StdoutLogHandler;
import com.applitools.eyes.TestResultSummary;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Applitools getting started demo.
 */
public class AppTest {

    private EyesRunner runner;
    private Eyes eyes;

    private WebDriver driver;

    @Before
    public void beforeEach() {
        //Initialize the Runner for your test.
        runner = new ClassicRunner();

        // Initialize the eyes SDK and set your private API key.
        eyes = new Eyes(runner);

        eyes.setLogHandler(new StdoutLogHandler(true));
        // Check if the Applitools API key is set in the environment
        if (System.getenv("APPLITOOLS_API_KEY") == null) {
            System.out.println("\n\n**** Please set APPLITOOLS_API_KEY in your environment ***");
            System.out.println("On Mac/Linux: export APPLITOOLS_API_KEY='YOUR_API_KEY'");
            System.out.println("On Windows: set APPLITOOLS_API_KEY='YOUR_API_KEY'");
            System.exit(0);
        }

        driver = new ChromeDriver();
    }


    @Test
    public void loginPage1() {
        // Start the test by setting AUT's name, window or the page name that's being tested, viewport width and height
        eyes.open(driver, "Acme app", "Login Page", new RectangleSize(1200, 700));

        // Navigate the browser to the "ACME" demo app
        driver.get("https://demo.applitools.com/index.html");

        // Visual checkpoint #1.
        eyes.checkWindow("Login Page");

        // End the test.
        eyes.closeAsync();
    }

    @Test
    public void loginPage2() {
        // Start the test by setting AUT's name, window or the page name that's being tested, viewport width and height
        eyes.open(driver, "Acme app", "Login Page", new RectangleSize(1200, 700));

        // Navigate the browser to the "ACME" demo app
        driver.get("https://demo.applitools.com/index_v2.html");

        // Visual checkpoint #1.
        eyes.checkWindow("Login Page");

        // End the test.
        eyes.closeAsync();
    }

    @Test
    public void mainPage1() {
        // Start the test by setting AUT's name, window or the page name that's being tested, viewport width and height
        eyes.open(driver, "Acme app", "Main Page", new RectangleSize(1200, 800));

        // Navigate the browser to the "ACME" demo app
        driver.get("https://demo.applitools.com/app.html");

        // Visual checkpoint #1.
        eyes.checkWindow("Main Page");

        // End the test.
        eyes.closeAsync();
    }

    @Test
    public void mainPage2() {
        // Start the test by setting AUT's name, window or the page name that's being tested, viewport width and height
        eyes.open(driver, "Acme app", "Main Page", new RectangleSize(1200, 800));

        // Navigate the browser to the "ACME" demo app
        driver.get("https://demo.applitools.com/app_v2.html");

        // Visual checkpoint #1.
        eyes.checkWindow("Main Page");

        // End the test.
        eyes.closeAsync();
    }


    @After
    public void afterEach() {
        // Close the browser.
        driver.quit();

        // If the test was aborted before eyes.close was called, ends the test as
        // aborted.
        eyes.abortIfNotClosed();

        //Wait and collect all test results
        TestResultSummary allTestResults = runner.getAllTestResults();
    }
}
