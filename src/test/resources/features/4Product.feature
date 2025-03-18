Feature: Product Search and Checkout Flow

  Scenario: User searches for a product, adds it to the cart, and completes the checkout process
    Given User is on the homepage
    When User logs in with valid credentials
    And User navigates to the products page
    And User searches for the product "Blue Top"
    And User adds the product to the cart
    And User proceeds to checkout
    And User enters card details "Visa" "12334548959" "435" "02" "2028"
    Then User should see the order confirmation message
    And User downloads the invoice and continues shopping