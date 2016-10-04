package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Deneme2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://twitter.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testDeneme2() throws Exception {
    driver.get(baseUrl + "/signup?lang=tr");
    driver.findElement(By.id("full-name")).clear();
    driver.findElement(By.id("full-name")).sendKeys("denemead");
    driver.findElement(By.id("full-name")).clear();
    driver.findElement(By.id("full-name")).sendKeys("denemead");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("pdwvvjji@emltmp.com");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("pdwvvjji@emltmp.com");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("pdwvvjji@emltmp.com.6161.");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("pdwvvjji@emltmp.com.6161.");
    driver.findElement(By.id("submit_button")).click();
    driver.findElement(By.id("submit_button")).click();
    driver.findElement(By.id("user-dropdown-toggle")).click();
    driver.findElement(By.id("user-dropdown-toggle")).click();
    driver.findElement(By.cssSelector("#signout-button > button.dropdown-link")).click();
    driver.findElement(By.cssSelector("#signout-button > button.dropdown-link")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
