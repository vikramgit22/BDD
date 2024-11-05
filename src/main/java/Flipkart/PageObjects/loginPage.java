package Flipkart.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class loginPage {


      WebDriver driver;

      By fliPLogin = By.xpath("//*[@title='Login']/span");

      By enternumberormail = By.xpath("//form[@autocomplete='on']//input[@type='text']");

      By homePage = By.xpath("//*[@title='Flipkart']");

      public loginPage(WebDriver driver)
      {
          this.driver = driver;
      }

      public void clickonLogin()
      {
          driver.findElement(fliPLogin).click();
      }

      public void onHoverLogin()
      {
          Actions actions = new Actions(driver);
          actions.moveToElement(driver.findElement(fliPLogin)).perform();
      }

      public void setNumber(int number)
      {
           driver.findElement(enternumberormail).sendKeys(Integer.toString(number));
      }

      public String getNumber()
      {
          return driver.findElement(enternumberormail).getText();
      }

      public void gotoHomepage()
      {
          driver.findElement(homePage).click();
      }






}
