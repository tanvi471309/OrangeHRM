package com.orangehrm.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static final ExtentReports extentReports = new ExtentReports();

    public static ExtentReports createInstance(String fileName) {    	
    	   	
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);       
        
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setReportName(fileName);        

        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("QA Automation Tester", "Tanvi Srivastava");
        extentReports.setSystemInfo("Organization", "Orange HRM");        
        
        return extentReports;
    }

}
