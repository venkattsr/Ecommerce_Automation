Feature: User Login Functionality

  Scenario Outline: Login with valid and invalid credentials
    Given User navigating to the home page
    When User clicks on the "Signup / Login"
    And User enters email "<Email>" and password "<Password>"
    And User clicks on the "Login"
    Then User should see the message "Logged in as <Username>"

    Examples: 
      | Email               | Password    | Username    |
      | venkat07@test.com | password123 | Venkata |

  Scenario Outline: Login with invalid credentials
    Given User navigating to the home page
    When User clicks on the "Signup / Login"
    And User enters email "<Email>" and password "<Password>"
    And User clicks on the "Login"
    Then User should see an error message "Your email or password is incorrect!"

    Examples: 
      | Email                 | Password      |
      | invalid.user@test.com | wrongPassword |