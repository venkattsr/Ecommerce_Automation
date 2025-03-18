package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import baseclass.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import user_registration.UserLogin;

public class UserLoginSteps {

	WebDriver driver;
    UserLogin loginuser;

    public UserLoginSteps() {
        this.driver = Hooks.getDriver();
        this.loginuser = new UserLogin(driver);
    }

    @Given("User navigating to the home page")
    public void user_navigates_to_home_page() {
        
    }

    @When("User clicks on the {string}")
    public void user_clicks_on(String option) {
    	if (option.equalsIgnoreCase("Signup / Login")) {
            loginuser.clickSignupLogin();
        } else if (option.equalsIgnoreCase("Login")) {
            loginuser.clickLogin();
        }
    }

    @When("User enters email {string} and password {string}")
    public void user_enters_email_and_password(String email, String password) {
        loginuser.enteremailpassword(email, password);
    }
    

    @Then("User should see the message {string}")
    public void user_should_see_message(String expectedUsername) {
    	String actualUsername = loginuser.getLoggedInUsername().trim();
        String actualMessage = "Logged in as " + actualUsername;
        Assert.assertEquals(actualMessage, expectedUsername);
    }
    

    @Then("User should see an error message {string}")
    public void user_should_see_an_error_message(String expectedError) {
    	 String actualError = loginuser.getLoginErrorMessage();
         Assert.assertEquals(actualError, expectedError);
    }

}