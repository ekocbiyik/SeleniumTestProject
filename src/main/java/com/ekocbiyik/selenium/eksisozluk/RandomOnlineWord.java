package com.ekocbiyik.selenium.eksisozluk;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Created by enbiya on 07.07.2017.
 */
public class RandomOnlineWord {


    public static String getRandomWord() {


        WebDriver driver = new HtmlUnitDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("https://www.uludagsozluk.com/");

        WebElement webElement = driver.findElement(By.id("index")).findElements(By.className("index-list")).get(0).findElements(By.tagName("a")).get(0);
        System.out.println("tıklanacak: " + webElement.getAttribute("href"));
        webElement.click();
        System.out.println("gidilen sayfa: " + driver.getCurrentUrl());

        String bulunanText = driver.findElement(By.className("entry-list")).findElements(By.className("entry-p")).get(0).getText();
        System.out.println("bulunan: " + bulunanText);
        driver.close();

        if (bulunanText.equalsIgnoreCase("")) {
            bulunanText = RandomKelime.getWord();
        }

        return bulunanText;
    }


}
