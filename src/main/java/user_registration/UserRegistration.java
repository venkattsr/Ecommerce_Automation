package user_registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepages.BasePage;

public class UserRegistration extends BasePage {

    public UserRegistration(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    private WebElement signupLoginButton;

    @FindBy(css = "input[name='name']")
    private WebElement nameInput;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement emailInput;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signupButton;

    @FindBy(id = "uniform-id_gender1")
    private WebElement radioButton;

    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "//select[@id='days']")
    WebElement daysDropdown;

    @FindBy(xpath = "//select[@id='months']")
    WebElement monthsDropdown;

    @FindBy(xpath = "//select[@id='years']")
    WebElement yearsDropdown;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement address1Input;

    @FindBy(id = "address2")
    private WebElement address2Input;

    @FindBy(id = "country")
    private WebElement countryDropdown;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;

    @FindBy(xpath = "//button[text()='Create Account']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//h2[@data-qa='account-created']")
    private WebElement accountCreatedMessage;

    @FindBy(linkText = "Continue")
    private WebElement continueButton;

    @FindBy(css = "a[href='/logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//i[@class='fa fa-home']")
    private WebElement homePageElement;

    public void clickElement(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    public void clickSignupLogin() { 
    	clickElement(signupLoginButton);
    	}

    public void fillSignupForm(String name, String email) {
        enterText(nameInput, name);
        enterText(emailInput, email);
    }

    public void clickSignupButton() { 
    	clickElement(signupButton);
    	}

    public void selectTitle(String title) {
        if (title.equalsIgnoreCase("Mr")) 
        	clickElement(radioButton);
    }

    public void enterPassword(String password) { 
    	enterText(passwordInput, password); 
    	}
    
    public void selectDateOfBirth(String day, String month, String year) {
        selectDropdownByVisibleText(daysDropdown, day);
        selectDropdownByVisibleText(monthsDropdown, month);
        selectDropdownByVisibleText(yearsDropdown, year);
    }

    public void selectNewsletter() {
        if (!newsletterCheckbox.isSelected()) {
        waitForElementToBeClickable(newsletterCheckbox);
    	clickElementWithScroll(newsletterCheckbox);
        }
    }

    public void enterAddressInformation(String firstname, String lastname, String company, String address1, String address2, String country, String state, String city, String zipcode, String mobileNumber) {
        enterText(firstNameInput, firstname);
        enterText(lastNameInput, lastname);
        enterText(companyInput, company);
        enterText(address1Input, address1);
        enterText(address2Input, address2);
        selectDropdownByVisibleText(countryDropdown, country);
        enterText(stateInput, state);
        enterText(cityInput, city);
        enterText(zipcodeInput, zipcode);
        enterText(mobileNumberInput, mobileNumber);
    }

    public void clickCreateAccount() {
    	clickElement(createAccountButton);
    	}

    public String getAccountCreatedMessage() { 
    	return accountCreatedMessage.getText(); 
    	}

    public void clickContinue() {
    	clickElement(continueButton);
    	}

    public void clickLogout() {
    	clickElement(logoutButton);
    	}

    public boolean isOnHomepage() {
    	return homePageElement.isDisplayed(); 
    	}
}