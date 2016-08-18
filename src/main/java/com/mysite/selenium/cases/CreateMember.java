package com.mysite.selenium.cases;

import com.mysite.selenium.utilities.MyLog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Created by enbiya on 18.08.2016.
 */
public class CreateMember {

    private WebDriver driver;
    private String baseUrl;
    private MyLog logger;

    private void setUp(){

        driver = new FirefoxDriver();
        baseUrl = "http://www.kitapyurdu.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        logger = new MyLog();

    }

    public void create(String username, String password){

        setUp();

        driver.get(baseUrl);
        logger.info("siteye gidildi");

        driver.findElement(By.linkText("kayıt olun")).click();
        logger.info("kayıt ol tıklandı");

        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(username);
        logger.info("isim girildi");

        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(username);
        logger.info("soyisim girildi");

        driver.findElement(By.xpath("(//input[@name='email'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys(username + password + "@yopmail.com");
        logger.info("mail girildi");

        driver.findElement(By.xpath("(//input[@name='password'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@name='password'])[2]")).sendKeys(password);
        logger.info("parola girildi");

        driver.findElement(By.name("confirm")).clear();
        driver.findElement(By.name("confirm")).sendKeys(password);
        logger.info("parola tekrar girildi");

        new Select(driver.findElement(By.name("day"))).selectByVisibleText("1");
        logger.info("gün seçildi");

        new Select(driver.findElement(By.name("month"))).selectByVisibleText("Ocak");
        logger.info("ay seçildi");

        new Select(driver.findElement(By.name("year"))).selectByVisibleText("1999");
        logger.info("yıl seçildi");

        driver.findElement(By.name("nickname")).clear();
        driver.findElement(By.name("nickname")).sendKeys(username + password);
        logger.info("nickname girildi");

        driver.findElement(By.name("agree")).click();
        logger.info("sözleşme kabul edildi");

        driver.findElement(By.cssSelector("div.fr > input.button")).click();
        logger.info("kayıt yapıldı");


        if (driver.getTitle().equalsIgnoreCase("Adres Defteri")){

            logger.pass("Kullanıcı tanımlandı");
            logger.endTest();
            driver.quit();

        } else {

            try{

                logger.error("Kullanıcı zaten kayıtlı");
                logger.addScreenCapture(driver);
                logger.endTest();

                throw new RuntimeException();

            } catch (RuntimeException e){

                logger.error(e.toString());
                logger.fail("Test başarısız!");
                e.printStackTrace();

            } finally {
                driver.quit();
            }
        }

    }

}
