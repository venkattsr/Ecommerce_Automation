package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import user_registration.UserRegistration;

public class UserRegistrationSteps {

	WebDriver driver;
    UserRegistration userRegistration;

    public UserRegistrationSteps() {
        this.driver = Hooks.getDriver(); 
        this.userRegistration = new UserRegistration(driver);
        driver.manage().window().maximize();
    }

    @Given("User navigates to the home page")
    public void user_navigates_to_home_page() {
        
    }

    @When("User clicks on {string}")
    public void user_clicks_on(String option) {
        if (option.equalsIgnoreCase("Signup / Login")) {
            userRegistration.clickSignupLogin();
        } else if (option.equalsIgnoreCase("Signup")) {
            userRegistration.clickSignupButton();
        } else if (option.equalsIgnoreCase("Create Account")) {
            userRegistration.clickCreateAccount();
        } 
    }

    @When("User fills out the popup form with name {string} and email {string}")
    public void user_fills_out_popup_form(String name, String email) {
        userRegistration.fillSignupForm(name, email);
    }

    @When("User fills out the registration form with the following details:")
    public void user_fills_out_registration_form(io.cucumber.datatable.DataTable dataTable) {
        var data = dataTable.asMaps(String.class, String.class).get(0);
        userRegistration.selectTitle(data.get("Title"));
        userRegistration.enterPassword(data.get("Password"));
        String[] dob = data.get("DOB").split("/");
        userRegistration.selectDateOfBirth(dob[0], dob[1], dob[2]);
        if (Boolean.parseBoolean(data.get("Newsletter"))) {
            userRegistration.selectNewsletter();
        }
        userRegistration.enterAddressInformation(
        	data.get("FirstName"),
        	data.get("LastName"),
        	data.get("Company"),
            data.get("Address"), 
            data.get("Address2"), 
            data.get("Country"), 
            data.get("State"), 
            data.get("City"), 
            data.get("Zipcode"), 
            data.get("MobileNumber")
        );
    }
    
    @Then("User clicks on Continue")
    public void user_clicks_on_continue() {
    	userRegistration.clickContinue();
    }

    @Then("User should see the {string} message")
    public void user_should_see_the_message(String expectedMessage) {
        Assert.assertEquals(userRegistration.getAccountCreatedMessage(), expectedMessage);
    }

    @Then("User logs out successfully")
    public void user_logs_out_successfully() {
        userRegistration.clickLogout();
    }

    @Then("User should be redirected to the homepage")
    public void user_should_be_redirected_to_the_homepage() {
        Assert.assertTrue(userRegistration.isOnHomepage(), "User was not redirected to the homepage.");
        
    }
}