Feature: Checking the Subscription Section

  Scenario: Subscribing with Valid Email
    Given User should be on the HomePage
    When User ScrollDown to the Subscribe Section
    And User Enters the Valid Email "venkat07@project.com"
    And User Clicks the Submit button
    Then User can see the Successfully Registerd Message

  Scenario: Tries to Subscribe with InValid Email
    Given User should be on the HomePage
    When User ScrollDown to the Subscribe Section
    And User Enters the Invalid Email "subscribe11@hotmail.com"
    And User Clicks the Submit button
    Then User Should See "Please include an '@' in the email-id as 'subscribe11' is missing an '@'."
