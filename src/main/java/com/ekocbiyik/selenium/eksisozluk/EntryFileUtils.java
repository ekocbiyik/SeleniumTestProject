package com.ekocbiyik.selenium.eksisozluk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by enbiya on 07.07.2017.
 */
public class EntryFileUtils {

    private static String PATH = "c:/allLinks.txt";

    public static void save(String content) {

        try {

            File linkFile = new File(PATH);
            if (!linkFile.exists()) {
                linkFile.createNewFile();
            }

            BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(linkFile, true)));
            bf.write(content);
            bf.newLine();
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("dosyaya kaydedildi: " + content);
        }
    }

    public static boolean linkExist(String link) {

        boolean isExist = false;

        try {

            File linkFile = new File(PATH);
            if (!linkFile.exists()) {
                linkFile.createNewFile();
            }

            BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream(linkFile), "UTF-8"));

            String line = null;
            while ((line = rd.readLine()) != null) {

                if (link.equalsIgnoreCase(line)) {
                    isExist = true;
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return isExist;
        }

    }


}
