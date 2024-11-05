package hooks;

import BaseDriver.BaseTest;
import Flipkart.utilities.ExtentMgr.ExtentManager;
import Flipkart.utilities.ScreenshotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class baseHooks {

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            WebDriver driver = BaseTest.getDriver();
            if (driver != null) {
                //final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                String screenshotPath = ScreenshotUtil.captureScreenshot(driver,scenario.getName());
                scenario.attach(screenshotPath.getBytes(), "image/png", "Failed Screenshot"); // Embed screenshot in the report
                System.out.println("Screenshot captured and attached for: " + scenario.getName());
            }
        }
    }

    @After
    public void afterScenario() {
        BaseTest.quitDriver();
    }
}
