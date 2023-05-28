package com.orangehrm.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orangehrm.driverscript.TestBase;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.TimePage;

public class EditTimeSheet extends TestBase{
	
	public static FileInputStream fis;
	public static Properties config = new Properties();
	public static final String homePageTitle="OrangeHRM";
	LoginPage loginPageObj;
	DashboardPage homePageObj;
	TimePage timePageObj;

	@BeforeClass
	public void readReadData() throws IOException {
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\orangehrm\\driverscript\\TestData.properties");
		config.load(fis);
		Reporter.log("Test Data loaded successfully");
	}
	
	@Test(priority = 1)
	public void loginApplication(){

		loginPageObj = PageFactory.initElements(driver, LoginPage.class);
		loginPageObj.enterUserName(config.getProperty("username"));
		loginPageObj.enterPassword(config.getProperty("password"));
		loginPageObj.clickLoginBtn();
		Assert.assertEquals(driver.getTitle(),homePageTitle,"Actual and Expected titles are same");
	}
	
	@Test(priority = 2)
	public void editTimeSheet()  throws InterruptedException {
		homePageObj = PageFactory.initElements(driver, DashboardPage.class);
		timePageObj= PageFactory.initElements(driver, TimePage.class);
		
		homePageObj.clickTimeLink();
		timePageObj.clickTimesheetTab();
		timePageObj.clickMyTimesheetOption();
		timePageObj.clickEditButton();
		timePageObj.clickProjectTextBox(config.getProperty("projectName"));
		timePageObj.selectProjectName();
		timePageObj.clickActivityDropDown();
		timePageObj.selectActivity();
		timePageObj.fillTimesheetTable(config.getProperty("timeEntrydata"));
		timePageObj.clickSaveButton();				
	}
	
	@Test(priority = 3)
	public void logoutApplication() throws InterruptedException {
		
		homePageObj = PageFactory.initElements(driver, DashboardPage.class);
		homePageObj.clickProfileDropDown();
		homePageObj.clickLogoutLink();		
	}
}
