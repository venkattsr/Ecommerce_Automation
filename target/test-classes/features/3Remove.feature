Feature: Removing Item Functionality

  Scenario: User searches for a product, adds it to the cart, and Removes item from the cart
    Given User on the homepage
    When User logging in with valid credentials
    And User navigating to the products page
    And User searches the product "Blue Top"
    And User adds that product to the cart
    And User removes item from the cart
    Then User should see the cart is empty

  Scenario: After logging in User searches for a product
    Given User on the homepage
    When User logging in with valid credentials
    And User navigating to the products page
    And User searches the product "Blue Top"
    Then User should be able to see the product

  Scenario: User searches for a product, adds it to the cart, and Removes item from the cart
    Given User on the homepage
    When User logging in with valid credentials
    And User navigating to the products page
    And User searches the product "Blue Top"
    And User adds that product to the cart
    Then User can see the product in the ViewCart

  Scenario: User searches for a product, adds it to the cart, and Removes item from the cart
    Given User on the homepage
    When User logging in with valid credentials
    And User navigating to the products page
    And User searches the product "Blue Top"
    And User adds that product to the cart
    And User proceeds to the checkout page
    Then It should show the order section
