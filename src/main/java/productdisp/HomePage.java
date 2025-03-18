package productdisp;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import basepages.BasePage;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
	    super(driver); 
	    PageFactory.initElements(driver, this);
	}
	

    @FindBy(linkText = "Signup / Login")
    WebElement signupLoginLink;

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(css = "button[data-qa='login-button']")
    WebElement loginButton;
    

    @FindBy(xpath="//a[text()=' Products']")
    WebElement productsLink;
    
    @FindBy(xpath="//input[@id='search_product']")
    WebElement searchbox;
    
    @FindBy(xpath="//button[@id='submit_search']")
    WebElement submitsearch;
    
    @FindBy(xpath="//a[@data-product-id=\"1\"]")
    WebElement additemcart;
    
    @FindBy(xpath="//u[text()=\"View Cart\"]")
    WebElement viewcart;
    
    @FindBy(xpath="//section[@id=\"cart_items\"]")
    WebElement cartview;
    
    @FindBy(xpath="//i[@class=\"fa fa-times\"]")
    WebElement removeitem;
    
    @FindBy(xpath="//span[@id='empty_cart']")
    WebElement cartmsg;
    
    @FindBy(xpath="//a[@class='btn btn-default check_out']")
    WebElement proceedcheckout;
    
    @FindBy(xpath="//section[@id='cart_items']")
    WebElement checkcheckout;
    
    @FindBy(xpath="//a[text()='Place Order']")
    WebElement placeorder;
    
    @FindBy(xpath="//input[@name=\"name_on_card\"]")
    WebElement cardname;
    
    @FindBy(xpath="//input[@name=\"card_number\"]")
    WebElement cardnumber;

    @FindBy(xpath="//input[@name=\"cvc\"]")
    WebElement cvcnumber;
    
    @FindBy(xpath="//input[@name=\"expiry_month\"]")
    WebElement expmonth;
    
    @FindBy(xpath="//input[@name=\"expiry_year\"]")
    WebElement expyear;
    
    @FindBy(xpath="//button[@id=\"submit\"]")
    WebElement submit;
    
    @FindBy(xpath="//div[@class='col-sm-4']")
    WebElement searchedprod;
    
    @FindBy(xpath="//h2[@data-qa=\"order-placed\"]")
    WebElement ordermessage;
    
    @FindBy(xpath="//a[text()='Download Invoice']")
    WebElement clickdownload;

    @FindBy(xpath="//a[text()='Continue']")
    WebElement clickcontinue;
    
    
    public void navigateToLoginPage() {
        onClick(signupLoginLink);
    }

    public void login(String email, String password) {
        enterText(emailField, email);
        enterText(passwordField, password);
        onClick(loginButton);
    }
    
    public void navigateToProductsPage() {
        onClick(productsLink);
    }
    
    public void entersearchtext(String pname) {
        enterText(searchbox, pname);
    }
        
    public void addingitem() {
        onClick(submitsearch);

        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", additemcart);

        waitForElementToBeClickable(additemcart);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", additemcart);
        
        waitForElementToBeClickable(viewcart);
        onClick(viewcart);

    }
    
    public void checkout() {
    	
        waitForElementToBeClickable(proceedcheckout);
        onClick(proceedcheckout);

        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", placeorder);

        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", placeorder);
    }

    
    
    public void addcarddet(String name, String num, String cvc, String month, String year) {
        
        waitForElementToBeVisible(cardnumber);
        enterText(cardnumber, num);

        waitForElementToBeVisible(cardname);
        enterText(cardname, name);

        waitForElementToBeVisible(cvcnumber);
        enterText(cvcnumber, cvc);

        waitForElementToBeVisible(expmonth);
        enterText(expmonth, month);

        waitForElementToBeVisible(expyear);
        enterText(expyear, year);

        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", submit);

        waitForElementToBeClickable(submit);
        onClick(submit);
    }
    
    public void removingitem() {
    	onClick(removeitem);
    }

    
    public String getmessage() {
    	return ordermessage.getText();
    }
    
    public void cartmessage() {
    	WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    	cartmsg.isDisplayed();
    }
    
    public void cartverify() {
    	WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    	cartview.isDisplayed();
    }
    
    public boolean proddisp() {
    	WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    	return searchedprod.isDisplayed();
    }
    
    public boolean verifydisp() {
    	WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    	return checkcheckout.isDisplayed();

    }
    public void finalstep() {
    	onClick(clickdownload);
    	onClick(clickcontinue);
    }
    
    
}