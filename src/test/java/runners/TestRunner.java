package runners;


import BaseDriver.BaseTest;
import Flipkart.listerners.TestListener;
import Flipkart.utilities.ExtentMgr.ExtentManager;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.stepdefinitions","hooks"},
        tags = "@Testcommit",
        plugin = {"pretty", "html:target/cucumber-reports.html"}

)


//@Listeners(TestListener.class)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void setup() {
        ExtentManager.createTest("Sample"); // Initialize the Extent Spark Report
    }

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser)
    {
        BaseTest.setDriver(browser);
    }

   /* @AfterClass
    public void tearDown()
    {
        BaseTest.quitDriver();
    }*/





}
