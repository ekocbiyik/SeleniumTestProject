package com.mysite.selenium.cases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by enbiya on 18.08.2016.
 */
public class MailApplication {

    static String username = "";
    static String password = "";

    public static void main(String[] args) {

        getUserPass();

        if (username.equals("") || password.equals("")){

            username = "aliahmetmehmet"; //aliahmetmehmet987654321@yopmail.com
            password = "987654321";
        }

        //kullanıcı oluşturma
        CreateMember t1 = new CreateMember();
        t1.create(username, password);

//        //login olma
//        LoginMember t2 = new LoginMember();
//        t2.login(username, password);
//
//        // kayıtlı kullanıcıyı tekrar oluşturma
//        CreateMember t3 = new CreateMember();
//        t3.create(username, password);

    }


    public static void getUserPass(){


        String inputPath = "D:\\rapor\\info.txt";
        String line;

        BufferedReader rd = null;
        try {

            rd = new BufferedReader(new FileReader(inputPath));
            while ((line = rd.readLine()) != null) {

                if (line.contains("username")) {
                    username = line.split("=")[1].trim();
                }

                if (line.contains("password")) {
                    password = line.split("=")[1].trim();
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
