@smoke
Feature: Shopping Cart Management API

  Scenario: User can add product to cart and checkout
    Given I login successfully as "nolivif958@craftapk.com" user
    And I add a watch product with below information:
      | productName | productCategory | productSubCategory | productPrice | productDescription | productFor |
      | Smart Watch | Technology      | watch              | 65000        | Samsung Originals  | Men        |
#    When I create a order for:
#      | country   |
#      | Sri Lanka |
#    Then the order details should be displayed as below:
