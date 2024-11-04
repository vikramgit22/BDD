package runners;


import BaseDriver.BaseTest;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)



public class TestRunner extends AbstractTestNGCucumberTests {

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser)
    {
        BaseTest.setDriver(browser);
    }

    @AfterClass
    public void tearDown()
    {
        BaseTest.quitDriver();
    }





}
