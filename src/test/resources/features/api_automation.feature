@smoke
Feature: Shopping Cart Management API

  Scenario Outline: Verify user can order a watch product
    Given I login successfully as "<email>" user
    And I add a watch product with below information:
      | productName   | productCategory | productSubCategory | productPrice | productDescription | productFor |
      | <productName> | Technology      | watch              | <price>      | <description>      | Men        |
    When I create a order form "<country>"
    Then the order details should be displayed as below:
      | orderBy | productName   | country   | orderPrice | productDescription | message                                  |
      | <email> | <productName> | <country> | <price>    | <description>      | Orders fetched for customer Successfully |
    And I delete my order
    And I delete added product

    Examples:
      | email                   | productName | price | description       | country   |
      | nolivif958@craftapk.com | Smart Watch | 65000 | Made in Sri Lanka | Sri Lanka |


  Scenario Outline: Verify user can order a shoe product
    Given I login successfully as "<email>" user
    And I add a shoe product with below information:
      | productName   | productCategory | productSubCategory | productPrice | productDescription | productFor |
      | <productName> | Nike            | Foot Ware          | <price>      | <description>      | Men        |
    When I create a order form "<country>"
    Then the order details should be displayed as below:
      | orderBy | productName   | country   | orderPrice | productDescription | message                                  |
      | <email> | <productName> | <country> | <price>    | <description>      | Orders fetched for customer Successfully |
    And I delete my order
    And I delete added product

    Examples:
      | email                   | productName        | price | description       | country   |
      | nolivif958@craftapk.com | Air Jordan 3 Retro | 89999 | Made in Sri Lanka | Australia |

  @ignore
  Scenario Outline: Verify user can order a household product
    Given I login successfully as "<email>" user
    And I add a household product with below information:
      | productName   | productCategory | productSubCategory | productPrice | productDescription | productFor |
      | <productName> | Philips         | LED Bulb           | <price>      | <description>      | Men        |
    When I create a order form "<country>"
    Then the order details should be displayed as below:
      | orderBy | productName   | country   | orderPrice | productDescription | message                                  |
      | <email> | <productName> | <country> | <price>    | <description>      | Orders fetched for customer Successfully |
    And I delete my order
    And I delete added product

    Examples:
      | email                   | productName | price | description                | country |
      | nolivif958@craftapk.com | 15W Bulb    | 200   | Saves a Energy, like a lot | Canada  |