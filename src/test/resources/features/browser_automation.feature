@smoke
Feature: Shopping Cart Management UI

  Scenario: User can add product to cart and checkout
    Given I have navigated to E-Commerce site
    And I search for product "IPHONE 13 PRO"
    And I note down the product price
    When I click on "Add To Cart" button
    And I navigate to shopping cart
    Then the MRP price should match the product price


  Scenario: User can add another product to cart and checkout
    Given I have navigated to E-Commerce site
    And I search for product "ADIDAS ORIGINAL"
    And I note down the product price
    When I click on "Add To Cart" button
    And I navigate to shopping cart
    Then the MRP price should match the product price


  #@ignore
  Scenario: User can add a third product to cart and checkout
    Given I have navigated to E-Commerce site
    And I search for product "ZARA COAT 3"
    And I note down the product price
    When I click on "Add To Cart" button
    And I navigate to shopping cart
    Then the MRP price should match the product price



