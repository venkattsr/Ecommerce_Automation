package Hooks;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }
    @After
    public void tearDown(Scenario scenario) {
    	takeScreenshot(scenario.getName());
    	if (driver != null) {
    		driver.quit();
    	}
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void takeScreenshot(String scenarioName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File screenshotDir = new File("./screenshots/");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File destination = new File(screenshotDir + "/" + scenarioName + "_" + timestamp + ".png");
            FileUtils.copyFile(screenshot, destination);
            System.out.println("Screenshot taken: " + destination.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}