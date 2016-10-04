import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Deneme1 {

  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://dropmail.me";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testDeneme1() throws Exception {
    driver.get(baseUrl + "/tr/");
    String tempEmail = driver.findElement(By.cssSelector("span.email")).getText();

    System.out.println(tempEmail);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }

}
