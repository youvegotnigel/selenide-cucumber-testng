package org.youvegotnigel.automation.runner;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.testng.annotations.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.screenshot;

public class Hooks {

    @BeforeClass
    @Parameters({"browser"})
    public static void setUp(String browser) {
        System.out.println("Tests running on :: " + browser);
        Configuration.browser = browser;
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("closing browser");
        closeWebDriver();
    }

    @AfterStep
    public void take_screenshot(Scenario scenario) {

        if(scenario.isFailed()) {
            String screenshotAsBase64 = screenshot(OutputType.BASE64);
            byte[] decoded = Base64.getDecoder().decode(screenshotAsBase64);
            scenario.attach(decoded, "image/png", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy_HH:mm:ss")));
        }
    }
}
