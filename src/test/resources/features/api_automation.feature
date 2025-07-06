@smoke
Feature: Shopping Cart Management API

  Scenario Outline: User can add product to cart and checkout
    Given I login successfully as "<email>" user
    And I add a watch product with below information:
      | productName   | productCategory | productSubCategory | productPrice | productDescription | productFor |
      | <productName> | Technology      | watch              | <price>      | <description>      | Men        |
    When I create a order form "<country>"
    Then the order details should be displayed as below:
      | orderBy | productName   | country   | orderPrice | productDescription | message                                  |
      | <email> | <productName> | <country> | <price>    | <description>      | Orders fetched for customer Successfully |

    Examples:
      | email                   | productName | price | description       | country   |
      | nolivif958@craftapk.com | Smart Watch | 65000 | Made in Sri Lanka | Sri Lanka |
