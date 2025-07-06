package org.youvegotnigel.automation.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.youvegotnigel.automation.context.TestContext;
import org.youvegotnigel.automation.pageobjects.CartPage;

public class CartSteps {

    private final CartPage cartPage = new CartPage();
    private final TestContext context = new TestContext();

    @Given("^I have navigated to E-Commerce site$")
    public void i_have_navigated_to_ecommerce_site() {
        cartPage.navigateToECommerce();
    }

    @Given("^I search for product \"(.+)\"$")
    public void i_search_for_product(String string) {
        context.setProductName(string);
        cartPage.searchForItem(string);
    }

    @Given("^I note down the product price$")
    public void i_note_down_the_product_price() {
        String price = cartPage.getActualPrice();
        System.out.println("Actual Price ::: " + price);
        context.setProductPrice(price);
    }

    @When("^I click on \"(.+)\" button$")
    public void i_click_on_button(String string) {
        cartPage.clickOnButton(string);
    }

    @When("^I navigate to shopping cart$")
    public void i_navigate_to_shopping_cart() {
        cartPage.navigateToCartPage();
    }

    @Then("^the MRP price should match the product price$")
    public void the_mrp_should_match_the_product_price() {
        String productName = context.getProductName();
        String productPrice = cartPage.getMaxRetailPriceForProduct(productName);
        Assert.assertEquals(productPrice, context.getProductPrice());
    }

}
