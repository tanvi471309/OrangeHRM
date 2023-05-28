package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.orangehrm.objectrepository.ObjectRepository;

public class SaveSystemUserPage {
	
	WebDriver driver;
	public SaveSystemUserPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath= ObjectRepository.userRoleDropDownArrowXpath) 
	@CacheLookup
	WebElement userRoleDropDownArrow;
	
	@FindBy(xpath= ObjectRepository.userRoleAdminXpath) 
	@CacheLookup
	WebElement userRoleAdminOption;
	
	@FindBy(xpath= ObjectRepository.userRoleESSXpath) 
	@CacheLookup
	WebElement userRoleESSOption;

	@FindBy(xpath= ObjectRepository.employeeNameTextBoxXpath) 
	@CacheLookup
	WebElement employeeNameTextBox;
	
//	@FindBy(xpath= ObjectRepository.employeeNameFromListXpath) 
//	@CacheLookup
//	WebElement employeeNameOption;

	@FindBy(xpath= ObjectRepository.statusDropDownArrowXpath) 
	@CacheLookup
	WebElement statusDropDownArrow;
	
	@FindBy(xpath= ObjectRepository.statusEnabledXpath) 
	@CacheLookup
	WebElement statusEnabledOption;
	
	@FindBy(xpath= ObjectRepository.statusDisabledXpath) 
	@CacheLookup
	WebElement statusDisabledOption;

	@FindBy(xpath= ObjectRepository.usernameTextBoxXpath) 
	@CacheLookup
	WebElement usernameTextBox;

	@FindBy(xpath= ObjectRepository.newUserPasswordTextBoxXpath) 
	@CacheLookup
	WebElement newUserPasswordTextBox;

	@FindBy(xpath= ObjectRepository.confirmPasswordTextBoxXpath) 
	@CacheLookup
	WebElement confirmPasswordTextBox;
	
	@FindBy(xpath= ObjectRepository.saveButtonXpath) 
	@CacheLookup
	WebElement saveButton;
	
	@FindBy(xpath= ObjectRepository.SystemUsersHeadingXpath) 
	@CacheLookup
	WebElement SystemUsersHeading;

	public void selectUserRole(String role){	
		userRoleDropDownArrow.click();
		WebDriverWait wait = new WebDriverWait(driver,5);
		if (role.equalsIgnoreCase("Admin")) {
			wait.until(ExpectedConditions.visibilityOf(userRoleAdminOption));
			userRoleAdminOption.click();
		} else {
			wait.until(ExpectedConditions.visibilityOf(userRoleESSOption));
			userRoleESSOption.click();
		}
		Reporter.log("User Role selected: "+role);
	}

	public void enterEmployeeName(String empName) {
		String empFirstName[]=empName.split(" ");
		employeeNameTextBox.sendKeys(empFirstName[0]);
		//Creating dynamic xpath
		String employeeNameXpath=ObjectRepository.employeeNameFromListXpath.replace("EmpName", empName);
		WebElement employeeNameOption=driver.findElement(By.xpath(employeeNameXpath));
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(employeeNameOption));
		employeeNameOption.click();
		Reporter.log("Employee Name entered: "+empName);
	}

	public void selectStatus(String status) {
		statusDropDownArrow.click();
		WebDriverWait wait = new WebDriverWait(driver,5);
		if (status.equalsIgnoreCase("Enabled")) {
			wait.until(ExpectedConditions.visibilityOf(statusEnabledOption));
			statusEnabledOption.click();
		} else {
			wait.until(ExpectedConditions.visibilityOf(statusDisabledOption));
			statusDisabledOption.click();
		}	    
		Reporter.log("Status selected: "+status);
	}

	public void enterUsername(String userName) {
		usernameTextBox.sendKeys(userName);
		Reporter.log("Username entered: "+userName);
	}

	public void enterPassword(String password) {
		newUserPasswordTextBox.sendKeys(password);
		Reporter.log("Password entered");
	}

	public void enterConfirmPassword(String password) {
		confirmPasswordTextBox.sendKeys(password);
		Reporter.log("Confirm Password entered");
	}
	
	public void clicksaveButton() throws InterruptedException {
		saveButton.click();
		Reporter.log("Save button clicked");		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOf(SystemUsersHeading));
	}
}
