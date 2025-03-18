package basepages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePagePF {

	WebDriver webDriver;

	public BasePagePF(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void enterText(WebElement element,String text) {
		element.sendKeys(text);
	}
	public void onClick(WebElement element) {
		element.click();
	}
}