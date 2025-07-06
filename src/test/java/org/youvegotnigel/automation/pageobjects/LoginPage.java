package org.youvegotnigel.automation.pageobjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private static final By INPUT_USERNAME = By.id("userEmail");
    private static final By INPUT_PASSWORD = By.id("userPassword");

    public void loginSuccessfully() {
        if(!isLoggedIn()) {
            $(INPUT_USERNAME).setValue("nolivif958@craftapk.com");
            $(INPUT_PASSWORD).setValue("Qwer1234").pressEnter();
        }
    }

    public boolean isLoggedIn() {
        return $(byTagAndText("button", "Sign Out")).is(visible);
    }
}
