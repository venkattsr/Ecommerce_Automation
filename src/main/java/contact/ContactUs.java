package contact;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepages.BasePage;

public class ContactUs extends BasePage{
	
	public ContactUs(WebDriver driver) {
	    super(driver); 
	    PageFactory.initElements(driver, this);
	}
	
	 	@FindBy(linkText = "Signup / Login")
	    WebElement signupLoginButton;

	    @FindBy(name = "email")
	    WebElement loginemail;

	    @FindBy(name = "password")
	    WebElement loginpassword;

	    @FindBy(css = "button[data-qa='login-button']")
	    WebElement loginButton;
	    
	    @FindBy(xpath="//a[text()= ' Contact us']")
	    WebElement contactbutton;
	    
	    @FindBy(xpath="//input[@name='name']")
	    WebElement contactname;
	    
	    @FindBy(xpath="//input[@name='email']")
	    public WebElement contactemail;
	    
	    @FindBy(xpath="//input[@name='subject']")
	    WebElement issuesubject;
	    
	    @FindBy(id="message")
	    WebElement contactmsg;
	    
	    @FindBy(xpath="//input[@name='upload_file']")
	    WebElement fileupload;
	    
	    @FindBy(xpath="//input[@name='submit']")
	    WebElement submitbutton;
	    
	    @FindBy(xpath="//*[@id='contact-page']/div[2]/div[1]/div/div[2]")
	    WebElement successmsg;
	    
	    public void navigateToLoginPage() {
	        onClick(signupLoginButton);
	    }
		
		public void enteremailpassword(String email, String password) {
	        enterText(loginemail, email);
	        enterText(loginpassword, password);
	    }
		
		public void clickLogin() {
			
	        onClick(loginButton, 5);
	        
	    }
		
		public void clickcontact() {
			
			onClick(contactbutton, 10);
		}
		
		public void fillform(String name, String mailid, String contmsg, String subject, String filepath) {
			enterText(contactname, name,5);
			enterText(contactemail, mailid, 5);
			enterText(issuesubject, subject, 5);
			enterText(contactmsg, contmsg, 5);
			fileupload.sendKeys(filepath);
		}
		public void submit() {
			clickElementWithScroll(submitbutton);
		}
		public void clickSubmitAndHandleAlert() {
			clickElementWithScroll(submitbutton);
	        Alert alert = webDriver.switchTo().alert();
	        System.out.println("Alert Text: " + alert.getText());
	        alert.accept();

	    }
		public boolean checksuccess() {
			return successmsg.isDisplayed();		}
		
		public String verifyRequiredFieldMessage(WebElement element, String expectedMessage) {
		    String actualMessage = element.getAttribute("validationMessage");
		    return element.getAttribute("validationMessage");		}

}