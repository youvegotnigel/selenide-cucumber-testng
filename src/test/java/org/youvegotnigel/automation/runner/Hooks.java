package org.youvegotnigel.automation.runner;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hooks {

    @BeforeClass
    @Parameters({"browser"})
    public static void setUp(String browser) {
        System.out.println("Tests running on :: " + browser);
        Configuration.browser = browser;
    }

    @AfterClass
    public static void tearDown() {
        closeWebDriver();
    }
}
