package org.stepdefinitions;

import BaseDriver.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Flipkart.PageObjects.loginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Demostepdefintions extends BaseTest {

    //WebDriver driver = BaseTest.getDriver();
    WebDriver driver = getDriver();
    loginPage loginPage;

    SoftAssert softAssert = new SoftAssert();

    @Given("user enter URL on browser")
    public void gT()
    {
      driver.get("https://www.flipkart.com/");
      loginPage = new loginPage(driver);
    }

    @When("clicked on enter")
    public void wT()
    {
        loginPage.clickonLogin();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        loginPage.setNumber(890987609);
        Assert.assertEquals("87",loginPage.getNumber());
    }

    @Then("homepage should be loaded")
    public void tT()
    {
        loginPage.gotoHomepage();
    }



}
