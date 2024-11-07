package org.stepdefinitions;

import BaseDriver.BaseTest;
import Flipkart.PageObjects.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class Testcommitstepdefinitons extends BaseTest {

    WebDriver driver = getDriver();
    loginPage loginPage;

    @Given("user makes the changes")
    public void devMakesChanges()
    {
        driver.get("https://github.com/vikramgit22");
        loginPage = new loginPage(driver);
    }

    @When("commit the code with message")
    public void devPushnCommit()
    {
        System.out.println(" Push n Commit ");
    }

    @Then("automatically same feature should run")
    public void runCommitFeature()
    {
        System.out.println(" Running feature ..........");
    }


}
