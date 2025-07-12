package org.youvegotnigel.automation.runner;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.screenshot;

public class Hooks {

    @BeforeAll
    public static void setUp() {
        String browser = System.getenv("browser");
        System.out.println("Tests running on :: " + browser);
        Configuration.browser = "chrome";
    }

    @AfterAll
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
