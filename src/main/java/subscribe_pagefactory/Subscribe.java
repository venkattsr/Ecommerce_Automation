package subscribe_pagefactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basepages.BasePage;

public class Subscribe extends BasePage{

	public Subscribe(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	public void scrollToSubscribeSection() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

	@FindBy(id = "susbscribe_email")
    public WebElement emailInput;
	
	public void enteremail(String email) {
		
		enterText(emailInput, email);
	}
	
	@FindBy(id = "subscribe")
	WebElement subscribeButton;
	
	public void clicksubmit() {
		onClick(subscribeButton);
	}
	
	@FindBy(xpath="//div[@class='alert-success alert']")
	WebElement successtext;
	
	public String getsuccess() {
		String message = successtext.getText();
        System.out.println("Success Message: " + message);
        return message;
	}
	
	public void verifyRequiredFieldMessage(WebElement element, String expectedMessage) {
	    String actualMessage = element.getAttribute("validationMessage");
	    if (actualMessage.equals(expectedMessage)) {
	    	Assert.assertTrue(true);
	    } else {
	    	Assert.assertFalse(false);
	    }
	}
}
