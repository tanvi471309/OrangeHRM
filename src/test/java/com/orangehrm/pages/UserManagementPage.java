package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.orangehrm.objectrepository.ObjectRepository;

public class UserManagementPage {
	WebDriver driver;	

	public UserManagementPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath= ObjectRepository.addButtonXpath) 
	@CacheLookup
	WebElement addButton;

	@FindBy(xpath= ObjectRepository.searchUserRoleDropDownArrowXpath) 
	@CacheLookup
	WebElement searchUserRoleDropDown;

	@FindBy(xpath= ObjectRepository.searchUserRoleAdminXpath) 
	@CacheLookup
	WebElement searchUserRoleAdminOption;

	@FindBy(xpath= ObjectRepository.searchUserRoleESSXpath) 
	@CacheLookup
	WebElement searchUserRoleESSOption;

	@FindBy(xpath= ObjectRepository.searchEmployeeNameTextBoxXpath) 
	@CacheLookup
	WebElement searchEmployeeNameTextBox;

//	@FindBy(xpath= ObjectRepository.searchEmployeeNameFromListXpath) 
//	@CacheLookup
//	WebElement searchEmployeeNameOption;

	@FindBy(xpath= ObjectRepository.searchStatusDropDownArrowXpath) 
	@CacheLookup
	WebElement searchStatusDropDownArrow;

	@FindBy(xpath= ObjectRepository.searchStatusEnabledXpath) 
	@CacheLookup
	WebElement searchStatusEnabledOption;

	@FindBy(xpath= ObjectRepository.searchStatusDisabledXpath) 
	@CacheLookup
	WebElement searchStatusDisabledOption;

	@FindBy(xpath= ObjectRepository.searchUsernameTextBoxXpath) 
	@CacheLookup
	WebElement searchUsernameTextBox;

	@FindBy(xpath= ObjectRepository.searchButtonXpath) 
	@CacheLookup
	WebElement searchButton;

	@FindBy(xpath= ObjectRepository.searchRecordXpath) 
	@CacheLookup
	List<WebElement> searchRecord;
	
	@FindBy(xpath= ObjectRepository.recordTableXpath) 
	@CacheLookup
	WebElement recordTable;
	
	@FindBy(xpath= ObjectRepository.SystemUsersHeadingXpath) 
	@CacheLookup
	WebElement SystemUsersHeading;	
	
	public void clickAddButton() {
		addButton.click();
		Reporter.log("Add Button clicked");
	}

	public void enterUsername(String userName) {
		searchUsernameTextBox.sendKeys(userName);
		Reporter.log("Username entered: "+userName);
	}

	public void selectUserRole(String role){	
		searchUserRoleDropDown.click();
		WebDriverWait wait = new WebDriverWait(driver,5);
		if (role.equalsIgnoreCase("Admin")) {
			wait.until(ExpectedConditions.visibilityOf(searchUserRoleAdminOption));
			searchUserRoleAdminOption.click();
		} else {
			wait.until(ExpectedConditions.visibilityOf(searchUserRoleESSOption));
			searchUserRoleESSOption.click();
		}
		Reporter.log("User Role selected: "+role);
	}

	public void enterEmployeeName(String empName) {
		String empFirstName[]=empName.split(" ");
		searchEmployeeNameTextBox.sendKeys(empFirstName[0]);
		//Creating dynamic xpath
		String employeeNameXpath=ObjectRepository.searchEmployeeNameFromListXpath.replace("EmpName", empName);
		WebElement searchEmployeeNameOption=driver.findElement(By.xpath(employeeNameXpath));
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(searchEmployeeNameOption));
		searchEmployeeNameOption.click();
		Reporter.log("Employee Name entered: "+empName);
	}

	public void selectStatus(String status) {
		searchStatusDropDownArrow.click();
		WebDriverWait wait = new WebDriverWait(driver,5);
		if (status.equalsIgnoreCase("Enabled")) {
			wait.until(ExpectedConditions.visibilityOf(searchStatusEnabledOption));
			searchStatusEnabledOption.click();
		} else {
			wait.until(ExpectedConditions.visibilityOf(searchStatusDisabledOption));
			searchStatusDisabledOption.click();
		}	    
		Reporter.log("Status selected: "+status);
	}

	public void clickSearchButton() {
		searchButton.click();
		Reporter.log("Search button clicked");
	}
	
	public void validateHeadingSystemUsers(String expectedHeading) {
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(SystemUsersHeading));
		String actualHeading=SystemUsersHeading.getText();
		if(actualHeading.equals(expectedHeading)) {
		Reporter.log("System Users heading displayed sucessfully");
		}else {
		Reporter.log("System Users heading not displayed");
		}
		}

	public void searchNewRecord() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(recordTable));
		List<WebElement> record = searchRecord;
		if (record.size()==2) {
			Reporter.log("Record found successfully");
			for (int i=1; i<record.size();i++){
				Reporter.log("Employee details:" + record.get(i).getText());
			}
			Reporter.log("***********************");
		} else {
			Reporter.log("Record not found");
		}
	}
}
