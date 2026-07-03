package Listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utility.BaseClass;
import Utility.ExtentReportsUtility;

public class ListenerImplementation extends BaseClass implements ITestListener {
	
	private ExtentReports extent;
	private ExtentTest test;
	
    @Override
    public void onStart(ITestContext context) {
    	 extent = ExtentReportsUtility.getReportObject();
        System.out.println("========= Test Execution Started =========");
    }


    @Override
    public void onTestStart(ITestResult result) {
    	 test = extent.createTest(result.getMethod().getMethodName());

        System.out.println(result.getName() + " Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	String path = captureScreen(result.getName() + "_Passed");

        test.pass("Test Passed");

        test.addScreenCaptureFromPath(path);

        System.out.println(result.getName() + " Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String path = captureScreen(result.getName() + "_Failed");

        test.fail("Test Failed");
       
        test.fail(result.getThrowable());

        test.addScreenCaptureFromPath(path);

        System.out.println(result.getName() + " Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	test.skip("Test Skipped");
        System.out.println(result.getName() + " Skipped");
    }
    
    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
        System.out.println("========= Test Execution Finished =========");
    }

    // Common Screenshot Method
    private String captureScreen(String testName) {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String path = "./Screenshots/" + testName + "_" + timestamp + ".png";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File dest = new File(path);

        try {
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot Captured Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}