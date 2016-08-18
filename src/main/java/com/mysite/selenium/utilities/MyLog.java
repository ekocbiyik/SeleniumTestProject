package com.mysite.selenium.utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by enbiya on 17.08.2016.
 */
public class MyLog {

    private ExtentReports report;
    private ExtentTest logger;
    private String destFilePath = "D:\\rapor\\";

    public MyLog(){

        String testName = (new SimpleDateFormat("dd MMM HH.mm.ss").format(new Date())).toString();
        report = new ExtentReports(destFilePath + testName+".html");
        logger = report.startTest(testName +" Test Sonuçları");

    }

    public void info(String log){
        logger.log(LogStatus.INFO, log);
    }

    public void error(String log){
        logger.log(LogStatus.ERROR, log);
    }

    public void fail(String log){
        logger.log(LogStatus.FAIL, log);
    }

    public void pass(String log){
        logger.log(LogStatus.PASS, log);
    }

    public void fatal(String log){
        logger.log(LogStatus.FATAL, log);
    }

    public void addScreenCapture(WebDriver driver){

        String errorFileName = (new SimpleDateFormat("dd MMM HH.mm.ss").format(new Date())).toString();
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenShotPath = destFilePath + "\\screenShots\\"+errorFileName+".png";
        try {

            
            FileUtils.copyFile(source, new File(screenShotPath));
            logger.log(LogStatus.INFO, "Hata görüntüsü2", logger.addScreenCapture(screenShotPath));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void endTest(){
        report.endTest(logger);
        report.flush();
    }

}
