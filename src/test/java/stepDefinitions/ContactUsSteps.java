package stepDefinitions;

import org.openqa.selenium.WebDriver;

import baseclass.Hooks;
import contact.ContactUs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsSteps {
	WebDriver webDriver;
	ContactUs contact;
	
	public ContactUsSteps() {
		this.webDriver = Hooks.getDriver();
		this.contact=new ContactUs(webDriver);
		webDriver.manage().window().maximize();
		
	}
	
	@Given("User Should be on Home Page")
	public void user_should_be_on_home_page() {
	}

	@When("User should click Loginbutton")
	public void user_should_click_loginbutton() {
	    contact.navigateToLoginPage();
	    
	}

	@When("User Should Enter Valid Credentials {string} and {string}")
	public void user_should_enter_valid_credentials_and(String email, String password) {
	    contact.enteremailpassword(email, password);
	}

	@When("User should click Login button")
	public void user_should_click_login_button() {
	    
	}

	@When("User can see the logged in homepage")
	public void user_can_see_the_logged_in_homepage() {
	    
	}
	
	@When("User should click Contact Us")
	public void user_should_click_contact_us() {
	    contact.clickcontact();
	}

	@When("User Should Fill the contact form {string} {string} {string} {string} {string}")
	public void user_should_fill_the_contact_form(String string, String string2, String string3, String string4, String string5) {
	    contact.fillform(string, string2, string3, string4, string5);
	    
	}

	@When("User Should click the submit and handle alert")
	public void user_should_click_the_submit_and_handle_alert() {
	    contact.clickSubmitAndHandleAlert();
	}
	
	@When("Try to click the submit button without Email")
	public void try_to_click_the_submit_button_without_email() {
	    contact.submit();
	}
	
	@Then("User should get the error message")
	public void user_should_get_the_error_message() {
		contact.verifyRequiredFieldMessage(contact.contactemail, "Please fill in this field.");
	}

	@Then("User can confirm that the form is submitted")
	public void user_can_confirm_that_the_form_is_submitted() {
	    contact.checksuccess();
	}

}
