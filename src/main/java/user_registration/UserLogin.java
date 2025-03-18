package user_registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepages.BasePage;

public class UserLogin extends BasePage{
	
	public UserLogin(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	@FindBy(xpath="//a[text()=' Signup / Login']")
	WebElement signupLoginButton;
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement loginemail;
	
	@FindBy(xpath="//input[@data-qa='login-password']")
    WebElement loginpassword;
	
	@FindBy(xpath="//button[@data-qa='login-button']")
    WebElement loginButton;
	
	@FindBy(xpath="//p[text() = 'Your email or password is incorrect!']")
    WebElement getLoginMessage;
	@FindBy(xpath="//a[contains(text(),'Logged in as')]")
    private WebElement loggedInUserMessage;
	
	public void clickSignupLogin() {
	    
	    onClick(signupLoginButton);
	}
	
	public void enteremailpassword(String email, String password) {
        enterText(loginemail, email);
        enterText(loginpassword, password);
    }
	
	public void clickLogin() {
        onClick(loginButton);
    }
	
	public String getLoggedInUsername() {
        return loggedInUserMessage.getText().replace("Logged in as ", "").trim();
    }
	
	public String getLoginErrorMessage() {
	    return getLoginMessage.getText();
	}
	
}
