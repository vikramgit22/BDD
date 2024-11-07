package org.stepdefinitions;

import BaseDriver.BaseTest;
import Flipkart.utilities.ExcelUtil.ExcelAIO;
import Flipkart.utilities.ExtentMgr.ExtentManager;
import com.aventstack.extentreports.ExtentTest;
import freemarker.core.Environment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Flipkart.PageObjects.loginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Demostepdefintions extends BaseTest {

    //WebDriver driver = BaseTest.getDriver();
    WebDriver driver = getDriver();
    loginPage loginPage;
    ExtentTest test = ExtentManager.getTest();
    //String path="C:\\Users\\Admin\\Downloads\\Book1.xlsx";
    String fileName = "Book1.xlsx";
    String projectDir = System.getProperty("user.dir");
    String filePath = projectDir + File.separator + "src" + File.separator + "test" + File.separator
            + "resources" + File.separator + "TestData" + File.separator + fileName;

    String sheet ="Sheet1";
    ExcelAIO excelAIO;

    {
        try {
            excelAIO = new ExcelAIO(filePath,sheet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    SoftAssert softAssert = new SoftAssert();

    @Given("user enter URL on browser")
    public void gT()
    {
      driver.get("https://www.flipkart.com/");
      loginPage = new loginPage(driver);
      test.info("HI");
    }

    @When("clicked on enter")
    public void wT()
    {
        loginPage.clickonLogin();

        //System.out.println(excelAIO.readColumnDataByHeader("Username"));
        List<String> columnData = excelAIO.readColumnDataByHeader("Username");
        if (!columnData.isEmpty()) {
            try {
                // Remove trailing ".0" if present, and parse as integer
                String data = columnData.get(0).trim();
                int number;
                if (data.endsWith(".0")) {
                    number = Double.valueOf(data).intValue(); // Convert Double to int if it's in a decimal form
                } else {
                    number = Integer.parseInt(data); // Otherwise, parse directly as integer
                }
                loginPage.setNumber(number); // Pass the converted integer to the method
            } catch (NumberFormatException e) {
                System.out.println("Error: The value in the 'Username' column is not a valid integer: " + columnData.get(0));
            }
           test.pass("Passed");
        } else {
            System.out.println("Error: The 'Username' column is empty or data not found.");
        }


        Assert.assertEquals(loginPage.getNumber(),"87");
    }

    @Then("homepage should be loaded")
    public void tT()
    {
        loginPage.gotoHomepage();

    }



}
