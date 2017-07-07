package com.ekocbiyik.selenium.eksisozluk;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by enbiya on 06.07.2017.
 */
public class MainApp {

    private static WebDriver driver;
    private static String username = "";
    private static String password = "";
    private static String oldEntry = "";
    private static List<String> allEntryList = new ArrayList<String>();


    public static void main(String[] args) {

        while (true) {
            init();
            if (login()) {

                if (newEntryExist()) {
                    entryGir();
                }
                logout();
            }

            try {
                TimeUnit.MINUTES.sleep(new Random().nextInt(10) + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void init() {

        driver = new HtmlUnitDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));

        username = "";
        password = "";
    }

    private static boolean login() {

        boolean sonuc = false;

        try {

            driver.get("https://eksisozluk.com/");
            WebElement linkLogin = driver.findElement(By.id("top-login-link"));
            linkLogin.click();

            if ("giriş - ekşi sözlük".equalsIgnoreCase(driver.getTitle())) {

                WebElement txtUsername = driver.findElement(By.id("username"));
                txtUsername.sendKeys(username);

                WebElement txtPassword = driver.findElement(By.id("password"));
                txtPassword.sendKeys(password);

                WebElement btnLogin = driver.findElement(By.className("btn-lg"));
                btnLogin.click();

                if ("ekşi sözlük - kutsal bilgi kaynağı".equalsIgnoreCase(driver.getTitle())) {
                    System.out.println("login başarılı!");
                    sonuc = true;
                } else {
                    System.out.println("login hatası!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return sonuc;
        }
    }

    private static boolean newEntryExist() {

        boolean sonuc = false;

        try {

            WebElement entryList = driver.findElement(By.id("partial-index"));
            String newEntry = entryList.findElement(By.tagName("ul")).findElements(By.tagName("li")).get(0).findElement(By.tagName("a")).getAttribute("href");

            if (!oldEntry.equalsIgnoreCase(newEntry)) {

                entryList.findElement(By.tagName("ul")).findElements(By.tagName("li")).get(0).findElement(By.tagName("a")).click();
                oldEntry = newEntry;
                sonuc = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            return sonuc;
        }
    }

    private static void entryGir() {

        try {

            if (EntryFileUtils.linkExist(oldEntry)) {
                System.out.println("bu entrye daha önce giriş yapıldı: " + oldEntry);
                return;
            }

            WebElement editbox = driver.findElement(By.id("editbox"));
            editbox.click();
            String word = RandomOnlineWord.getRandomWord();
            editbox.sendKeys(word);

            WebElement btnEntry = driver.findElement(By.className("entry-edit-form-container")).findElement(By.className("primary"));
            btnEntry.click();

            allEntryList.add(oldEntry);
            EntryFileUtils.save(oldEntry);
            System.out.println("(toplam: " + allEntryList.size() + ") Entry girildi: " + oldEntry + " - " + word);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("entry gir bitti!");
        }
    }

    private static void logout() {
        driver.get("https://eksisozluk.com/terk");
        System.out.println("logout oldu!");
    }

}
