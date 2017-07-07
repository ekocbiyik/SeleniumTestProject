package com.ekocbiyik.selenium.cases;

import com.ekocbiyik.selenium.utilities.MyLog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by enbiya on 18.08.2016.
 */
public class LoginMember {

    private WebDriver driver;
    private String baseUrl;
    private MyLog logger;

    private void setUp(){

        driver = new FirefoxDriver();
        baseUrl = "http://www.kitapyurdu.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        logger = new MyLog();

    }


    public MyLog login(String username, String password, MyLog logger){

        this.logger = logger;
        setUp();

        driver.get(baseUrl + "index.php?route=common/home");
        logger.info("login sayfasına gitti");

        driver.findElement(By.linkText("giriş yapın")).click();
        logger.info("login tıklandı");

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(username + password + "@yopmail.com");
        logger.info("email girildi");

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        logger.info("password girildi");

        driver.findElement(By.linkText("Oturum Aç")).click();
        logger.info("oturum aç tıklandı");

        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!driver.getPageSource().contains("Hoş geldin ziyaretçi")){

            logger.pass("Login işlemi başarılı");
//            logger.endTest();
            driver.quit();

        } else {

            try{

                logger.error("Login hatası");
                logger.addScreenCapture(driver);
//                logger.endTest();

                throw new RuntimeException();

            } catch (RuntimeException e){

                logger.error(e.toString());
                logger.fail("Test başarısız!");
                e.printStackTrace();

            } finally {
                driver.quit();
            }
        }

        return logger;
    }

}
