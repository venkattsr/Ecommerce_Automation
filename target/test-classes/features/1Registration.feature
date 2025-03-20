Feature: User Registration and Login Functionality

  Scenario Outline: Register a new user and verifying account creation
    Given User navigates to the home page
    When User clicks on "Signup / Login"
    And User fills out the popup form with name "<Name>" and email "<Email>"
    And User clicks on "Signup"
    And User fills out the registration form with the following details:
      | Title   | Password   | DOB   | Newsletter   | Offers   | FirstName   | LastName   | Company   | Address   | Address2   | Country   | State   | City   | Zipcode   | MobileNumber   |
      | <Title> | <Password> | <DOB> | <Newsletter> | <Offers> | <FirstName> | <LastName> | <Company> | <Address> | <Address2> | <Country> | <State> | <City> | <Zipcode> | <MobileNumber> |
    And User clicks on "Create Account"
    Then User should see the "ACCOUNT CREATED!" message
    And User clicks on Continue
    And User logs out successfully
    And User should be redirected to the homepage

    Examples: 
      | Name    | Email              | Title | Password    | DOB             | Newsletter | Offers | FirstName | LastName | Company | Address    | Address2 | Country | State     | City  | Zipcode | MobileNumber |
      | Venkata | vvenkat017@test.com | Mr    | password123 | 14/January/2002 | true       | true   | Venkat    | a        | Testing | 12 Main St | ops      | India   | Tamilnadu | Hosur |  635110 |   9123456789 |
