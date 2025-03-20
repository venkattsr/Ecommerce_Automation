package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import productdisp.HomePage;

public class ProductSteps {
	WebDriver driver;
    HomePage homePage;
    
    public ProductSteps() {
        this.driver = Hooks.getDriver();
        this.homePage = new HomePage(driver);
        driver.manage().window().maximize();

    }

    @Given("User is on the homepage")
    public void user_is_on_the_homepage() {
        
    }

    @When("User logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        homePage.navigateToLoginPage();
        homePage.login("venkat07@test.com", "password123");
    }

    @When("User navigates to the products page")
    public void user_navigates_to_the_products_page() {
        homePage.navigateToProductsPage();
    }

    @When("User searches for the product {string}")
    public void user_searches_for_the_product(String productName) {
        homePage.entersearchtext(productName);
    }

    @When("User adds the product to the cart")
    public void user_adds_the_product_to_the_cart() {
        homePage.addingitem();
    }

    @When("User proceeds to checkout")
    public void user_proceeds_to_checkout() {
        homePage.checkout();
    }

    @When("User enters card details {string} {string} {string} {string} {string}")
    public void user_enters_card_details(String name, String num, String cvc, String month, String year) {
        homePage.addcarddet(name, num, cvc, month, year);
    }
    
    @Then("User should see the order confirmation message")
    public void user_should_see_the_order_confirmation_message() {
        String message = homePage.getmessage();
        Assert.assertEquals(message, "ORDER PLACED!");
    }

    @Then("User downloads the invoice and continues shopping")
    public void user_downloads_the_invoice_and_continues_shopping() {
        homePage.finalstep();
    }
    
    
}