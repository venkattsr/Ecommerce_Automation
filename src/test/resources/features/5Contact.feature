Feature: Handling the contactus Functionality

  Scenario: Providing Valid Information and Submitting the contact form
    Given User Should be on Home Page
    When User should click Loginbutton
    And User Should Enter Valid Credentials "venkat07@exam.com" and "password123"
    And User should click Login button
    And User can see the logged in homepage
    And User should click Contact Us
    And User Should Fill the contact form "Venkat" "venkat07@exam.com" "About Product" "Check the attached file" "/Users/venkattsr/Downloads/Ecomm/./screenshots"
    And User Should click the submit and handle alert
    Then User can confirm that the form is submitted

  Scenario: Providing Information with missing fields to verify error message
    Given User Should be on Home Page
    When User should click Loginbutton
    And User Should Enter Valid Credentials "venkat07@exam.com" and "password123"
    And User should click Login button
    And User can see the logged in homepage
    And User should click Contact Us
    And User Should Fill the contact form "Venkat" "" "About Product" "Check the attached file" "/Users/venkattsr/Downloads/Ecomm/./screenshots"
    And Try to click the submit button without Email
    Then User should get the error message
