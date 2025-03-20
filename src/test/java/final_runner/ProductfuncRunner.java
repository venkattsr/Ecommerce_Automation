package final_runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/4Product.feature",
        glue = {"stepDefinitions", "Hooks"},
        plugin=	{
        		"pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        monochrome = true
)
public class ProductfuncRunner extends AbstractTestNGCucumberTests {
}