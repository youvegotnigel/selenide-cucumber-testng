package org.youvegotnigel.automation.pageobjects;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    public void navigateToSite(String url) {
        Configuration.baseUrl = url;
        Configuration.timeout = 5 * 1000L;
        open("/");
    }

    public void clickOnButton(String buttonText)  {
        $(byTagAndText("button", buttonText)).shouldBe(clickable).click();
    }

}
