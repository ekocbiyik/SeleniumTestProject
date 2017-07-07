package com.ekocbiyik.selenium.twitter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by enbiya on 18.08.2016.
 */
public class CreateMember {

    public WebDriver driver;

    public String getEmail(){

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://dropmail.me/tr/");

        return driver.findElement(By.cssSelector("span.email")).getText();

    }


}
