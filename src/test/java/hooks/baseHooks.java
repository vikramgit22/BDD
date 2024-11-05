package hooks;

import BaseDriver.BaseTest;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class baseHooks {

    @AfterStep
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            WebDriver driver = BaseTest.getDriver();
            if (driver != null) {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failed Screenshot"); // Embed screenshot in the report
            }
        }
    }

    @After
    public void afterScenario() {
        BaseTest.quitDriver();
    }
}
