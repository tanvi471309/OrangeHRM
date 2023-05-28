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
import com.orangehrm.pages.MyInfoPage;
import com.orangehrm.pages.PIMPage;

public class ViewAndEditEmployeeDetails extends TestBase{

	public static FileInputStream fis;
	public static Properties config = new Properties();
	public static final String homePageTitle="OrangeHRM";
	LoginPage loginPageObj;
	DashboardPage homePageObj;
	PIMPage pimPageObj;
	MyInfoPage myInfoObj;

	@BeforeClass
	public void readReadData() throws IOException {

		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\orangehrm\\driverscript\\TestData.properties");
		config.load(fis);
		Reporter.log("Test Data loaded successfully");
	}


	@Test(priority = 1)
	public void loginApplication() {

		loginPageObj = PageFactory.initElements(driver, LoginPage.class);
		loginPageObj.enterUserName(config.getProperty("username"));
		loginPageObj.enterPassword(config.getProperty("password"));
		loginPageObj.clickLoginBtn();
		Assert.assertEquals(driver.getTitle(),homePageTitle,"Actual and Expected titles are same");
	}
	@Test(priority = 2)
	public void viewEmployeeList() throws InterruptedException {

		homePageObj = PageFactory.initElements(driver, DashboardPage.class);
		pimPageObj = PageFactory.initElements(driver, PIMPage.class);
		homePageObj.clickPIMTab();		
		pimPageObj.getAllEmployeeDetails();

	}
	@Test(priority = 3)
	public void editEmployeeDetails() {

		pimPageObj = PageFactory.initElements(driver, PIMPage.class);
		myInfoObj=PageFactory.initElements(driver, MyInfoPage.class);
		pimPageObj.scrollToEmployeeDetailsUsingID(config.getProperty("employeeID"));
		pimPageObj.selectEmployeeDetailsCheckBox(config.getProperty("employeeID"));
		pimPageObj.clickEditButton(config.getProperty("employeeID"));	
		myInfoObj.enterFirstName(config.getProperty("firstName"));	
		myInfoObj.enterMiddleName(config.getProperty("middleName"));
		myInfoObj.enterLastName(config.getProperty("lastname"));
		myInfoObj.enterNickName(config.getProperty("nickName"));
		myInfoObj.enterEmployeeID(config.getProperty("employeeID"));
		myInfoObj.enterOtherID(config.getProperty("otherID"));
		myInfoObj.enterDriverLicenseNum(config.getProperty("driverLicenseNumber"));
		myInfoObj.enterSSNNum(config.getProperty("ssnNumber"));
		myInfoObj.enterSINNum(config.getProperty("sinNumber"));
		myInfoObj.selectSmokerCheckBox();
		myInfoObj.selectNationality(config.getProperty("nationality"));		
		myInfoObj.selectMaritalStatus(config.getProperty("maritalstatus"));
		myInfoObj.clickSaveButton();		
	}
	@Test(priority = 4)
	public void logoutApplication() throws InterruptedException {

		homePageObj = PageFactory.initElements(driver, DashboardPage.class);

		homePageObj.clickProfileDropDown();
		homePageObj.clickLogoutLink();
	}

}
