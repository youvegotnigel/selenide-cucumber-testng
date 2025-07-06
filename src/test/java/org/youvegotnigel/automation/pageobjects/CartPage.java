package org.youvegotnigel.automation.pageobjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CartPage extends BasePage {

    private static final By SEARCH_INPUT = By.cssSelector("[formcontrolname=\"productName\"]");
    private static final By ACTUAL_PRICE = By.xpath("//h5/following-sibling::div/div");
    private static final By CART_NOTIFICATION = By.xpath("//button[@routerlink=\"/dashboard/cart\"]/label");

    public void navigateToECommerce() {
        navigateToSite("https://rahulshettyacademy.com/client");
        LoginPage loginPage = new LoginPage();
        loginPage.loginSuccessfully();
    }

    public void navigateToCartPage() {
        //$(CART_NOTIFICATION).shouldHave(text("1")).click();
        $(CART_NOTIFICATION).shouldBe(visible).click();
    }

    public void searchForItem(String item) {
        $$(SEARCH_INPUT).filter(interactable).first().shouldBe(editable).setValue(item).pressEnter();
    }

    public String getActualPrice() {
        sleep(500);
        return $$(ACTUAL_PRICE).filter(visible).first().text().trim();
    }

    public String getMaxRetailPriceForProduct(String productName) {
        String xpath = String.format("//*[text()=\"%s\"]/following-sibling::p[1]", productName);
        String mrp = $x(xpath).highlight().text();
        return mrp.replaceAll("MRP", "").trim();
    }

}
