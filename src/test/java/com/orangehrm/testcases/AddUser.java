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
import com.orangehrm.pages.SaveSystemUserPage;
import com.orangehrm.pages.UserManagementPage;

public class AddUser extends TestBase{

	public static FileInputStream fis;
	public static Properties config = new Properties();
	public static final String homePageTitle="OrangeHRM";
	LoginPage loginPageObj;
	DashboardPage homePageObj;
	UserManagementPage userManagementObj;
	SaveSystemUserPage saveUserObj;

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
	public void addEmployee() throws InterruptedException {

		homePageObj = PageFactory.initElements(driver, DashboardPage.class);
		userManagementObj=PageFactory.initElements(driver, UserManagementPage.class);
		saveUserObj=PageFactory.initElements(driver, SaveSystemUserPage.class);

		homePageObj.clickAdminTab();
		userManagementObj.clickAddButton();
		saveUserObj.selectUserRole(config.getProperty("userRole"));
		saveUserObj.enterEmployeeName(config.getProperty("employeeName"));
		saveUserObj.selectStatus(config.getProperty("status"));
		saveUserObj.enterUsername(config.getProperty("newUserUsername"));
		saveUserObj.enterPassword(config.getProperty("newUserPassword"));
		saveUserObj.enterConfirmPassword(config.getProperty("newUserPassword"));
		saveUserObj.clicksaveButton();		
	}

	@Test(priority = 3)
	public void searchEmployee() throws InterruptedException {

		userManagementObj=PageFactory.initElements(driver, UserManagementPage.class);
		userManagementObj.validateHeadingSystemUsers(config.getProperty("expectedSystemUsersPageheading"));
		userManagementObj.enterUsername(config.getProperty("newUserUsername"));
		userManagementObj.selectUserRole(config.getProperty("userRole"));
		userManagementObj.enterEmployeeName(config.getProperty("employeeName"));
		userManagementObj.selectStatus(config.getProperty("status"));
		userManagementObj.clickSearchButton();
		userManagementObj.searchNewRecord();
	}
	@Test(priority = 4)
	public void logoutApplication() throws InterruptedException {

		homePageObj = PageFactory.initElements(driver, DashboardPage.class);

		homePageObj.clickProfileDropDown();
		homePageObj.clickLogoutLink();		
	}
}
