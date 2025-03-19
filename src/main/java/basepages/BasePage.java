package basepages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BasePage {
	protected WebDriver webDriver;
	private WebDriverWait wait;

	public BasePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
		PageFactory.initElements(webDriver, this);
	}
	
	public void waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

	
	public WebElement findWebElement(By locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

	public void onClick(WebElement element, int timeoutInSeconds) {
		waitForElementToBeClickable(element, timeoutInSeconds);
		element.click();
	}
	
	public void onClick(WebElement element) {
		waitForElementToBeClickable(element);
		element.click();
	}
	public void enterText(WebElement element, String text) {
        if (element.isDisplayed() && element.isEnabled()) {
            element.sendKeys(text);
        } else {
            System.out.println("Element is not interactable");
        }
    }
	public void selectDropdownByValue(WebElement element, String value) {
	    Select select = new Select(element);
	    select.selectByValue(value);
	}
	

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public void waitForElementToBeVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void enterText(WebElement element, String text, int timeoutInSeconds) {
        waitForElementToBeVisible(element, timeoutInSeconds);
        element.clear();
        element.sendKeys(text);
    }
    public WebElement waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

	public void selectDropdownByVisibleText(WebElement element, String text) {
	    Select select = new Select(element);
	    select.selectByVisibleText(text);
	}

	public void selectDropdownByIndex(WebElement element, int index) {
	    Select select = new Select(element);
	    select.selectByIndex(index);
	}
	public WebDriver getWebDriver() {
	    return webDriver;
	}
	
	public void scrollToElement(WebElement element) {
	    ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public void clickElementWithScroll(WebElement element) {
	    scrollToElement(element);
	    element.click();
	}
}