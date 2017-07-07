package com.ekocbiyik.selenium.cases;

import com.ekocbiyik.selenium.utilities.MyLog;
import com.ekocbiyik.selenium.utilities.ReportLogs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by enbiya on 18.08.2016.
 */
public class MailApplication {

    static String username = "";
    static String password = "";

    public static void main(String[] args) {

//        getUserPass();

        if (username.equals("") || password.equals("")){

            username = "alivelikirk950"; //aliahmetmehmet987654321@yopmail.com
            password = "987654321";
        }

        MyLog logger = new MyLog();


        //kullanıcı oluşturma
        CreateMember t1 = new CreateMember();
        logger = t1.create(username, password, logger);


        //login olma
        LoginMember t2 = new LoginMember();
        logger = t2.login(username, password, logger);
//
        // kayıtlı kullanıcıyı tekrar oluşturma
        CreateMember t3 = new CreateMember();
        logger = t3.create(username, password, logger);

        new ReportLogs().executeReports(logger);
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
