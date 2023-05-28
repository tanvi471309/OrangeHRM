package com.orangehrm.listeners;

import java.io.IOException;

import java.util.Date;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.orangehrm.driverscript.TestBase;
import com.orangehrm.utilities.ExtentManager;
import com.orangehrm.utilities.TestUtil;


public class CustomListeners extends TestBase implements ITestListener {

	static Date d = new Date();
	static String fileName = "Results_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	static String messageBody;
	private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"\\Reports\\"+fileName);
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {

		ExtentTest test = extent.createTest(result.getTestClass().getName()+"     @TestCase : "+result.getMethod().getMethodName());
		testReport.set(test);       

	}

	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " IS PASSED"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		
		if(config.getProperty("capturescreenshot").equalsIgnoreCase("true")) {
			try {
				testReport.get().pass(m);	
				TestUtil.captureScreenshot();
				testReport.get().pass("<b>" + "<font color=" + "green>" + "Screenshot of passed" + "</font>" + "</b>",
						MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenshotName)
						.build());
			} catch (IOException e) 
			{
				e.printStackTrace();
			}			
		}
		else
		{
			testReport.get().pass(m);	
		}

	}

	public void onTestFailure(ITestResult result) {

		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " IS FAILED"+"</b>";	
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m);
		testReport.get().log(Status.FAIL, "FAILED LOG : " + result.getThrowable().getLocalizedMessage());
		
				
		try {
			TestUtil.captureScreenshot();
			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenshotName)
					.build());
		} catch (IOException e) 
		{
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"Test Case:- "+ methodName+ " IS SKIPPED"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReport.get().skip(m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}


	public void onFinish(ITestContext context) {

		if (extent != null) {
			extent.flush();
		}

	}

}
