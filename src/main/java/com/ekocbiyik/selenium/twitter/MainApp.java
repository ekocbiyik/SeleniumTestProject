package com.ekocbiyik.selenium.twitter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by enbiya on 07.09.2016.
 */
public class MainApp {


    private static WebDriver driver;
    private static String baseUrl;


    public static void main(String[] args) {


        for (int i = 0; i < 61; i++) {

            createMember();

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static void setUp(){

        driver = new FirefoxDriver();
        baseUrl = "https://twitter.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }


    private static void createMember(){

        setUp();
        driver.get(baseUrl + "/signup/");


        CreateMember member = new CreateMember();

        String email = member.getEmail();
        String name = email.split("@")[0];
        String password = email + ".6161.";

        driver.findElement(By.id("full-name")).clear();
        driver.findElement(By.id("full-name")).sendKeys(name);

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit_button")).click();

        driver.get(baseUrl);

        driver.findElement(By.id("user-dropdown-toggle")).click();
        driver.findElement(By.cssSelector("#signout-button > button.dropdown-link")).click();

        saveUser(email);

        member.driver.quit();

        driver.quit();


    }


    private static void saveUser(String email){

        System.out.println(email);


        String fileDirect = "D:\\aaa\\";

        File folder = new File(fileDirect);
        if (!folder.exists()) {
            folder.mkdir();
        }

        String filePath = fileDirect + "twitterUsers.txt";

        File usersFile = new File(filePath);
        if (!usersFile.exists()) {
            try {
                usersFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        BufferedWriter out = null;
        try {

            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(usersFile,true), "UTF-8"));
            out.write(email);
            out.newLine();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


}
