package stepDefinitions;

import org.openqa.selenium.WebDriver;

import baseclass.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import subscribe_pagefactory.Subscribe;

public class SubscribeStep {
	
	WebDriver webDriver;
	Subscribe subscribe;
	
	public SubscribeStep() {
		this.webDriver = Hooks.getDriver();
		this.subscribe=new Subscribe(webDriver);
		webDriver.manage().window().maximize();
		
	}
	@Given("User should be on the HomePage")
	public void user_should_be_on_the_home_page() {
	    
	}

	@When("User ScrollDown to the Subscribe Section")
	public void user_scroll_down_to_the_subscribe_section() {
		subscribe.scrollToSubscribeSection();
	}

	@When("User Enters the Valid Email {string}")
	public void user_enters_the_valid_email(String email) {
	    subscribe.enteremail(email);
	}

	@When("User Clicks the Submit button")
	public void user_clicks_the_submit_button() {
	    subscribe.clicksubmit();
	}
	
	@When("User Enters the Invalid Email {string}")
	public void user_enters_the_invalid_email(String email) {
		subscribe.enteremail(email);
	}
	
	@Then("User Should See {string}")
	public void user_should_see(String string) {
		subscribe.verifyRequiredFieldMessage(subscribe.emailInput, string);
	}

	@Then("User can see the Successfully Registerd Message")
	public void user_can_see_the_successfully_registerd_message() {
	    subscribe.getsuccess();
	}

}
