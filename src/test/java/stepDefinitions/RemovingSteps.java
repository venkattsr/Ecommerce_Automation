package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import productdisp.HomePage;

public class RemovingSteps {
	Hooks hooks;
	WebDriver driver;
    HomePage homePage;
    
    public RemovingSteps(Hooks hooks) {  
        this.hooks = hooks;
    }
    public RemovingSteps() {
        this.driver = Hooks.getDriver();
        this.homePage = new HomePage(driver);
        driver.manage().window().maximize();

    }
    
    @Given("User on the homepage")
    public void user_on_the_homepage() {
        
    }

    @When("User logging in with valid credentials")
    public void user_logging_in_with_valid_credentials() {
        homePage.navigateToLoginPage();
        homePage.login("venkat07@test.com", "password123");
    }

    @When("User navigating to the products page")
    public void user_navigating_to_the_products_page() {
        homePage.navigateToProductsPage();
    }

    @When("User searches the product {string}")
    public void user_searches_the_product(String productName) {
        homePage.entersearchtext(productName);
    }

    @When("User adds that product to the cart")
    public void user_adds_that_product_to_the_cart() {
        homePage.addingitem();
    }
    
    @When("User proceeds to the checkout page")
    public void user_proceeds_to_the_checkout_page() {
        homePage.checkout();
    }

    @When("User removes item from the cart")
    public void user_removes_item_from_the_cart() {
    	homePage.removingitem();
    }
    
    
    
    @Then("User should see the cart is empty")
    public void user_should_see_the_cart_is_empty() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emptyCartSection = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[@id='empty_cart']"))
        );
        Assert.assertTrue(emptyCartSection.isDisplayed(), "Empty cart section is not displayed.");

    }
    
    @Then("User should be able to see the product")
    public void user_should_be_able_to_see_the_product() {
    	homePage.proddisp();
    }
    
    @Then("User can see the product in the ViewCart")
    public void user_can_see_the_product_in_the_ViewCart() {
    	homePage.cartverify();
    }

    @Then("It should show the order section")
    public void it_should_show_the_order_section() {
    	homePage.verifydisp();
    }

}
