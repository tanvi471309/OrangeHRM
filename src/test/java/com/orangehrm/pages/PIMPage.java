package com.orangehrm.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.orangehrm.objectrepository.ObjectRepository;

public class PIMPage {
	WebDriver driver;	

	public PIMPage(WebDriver driver) {
		this.driver = driver;
	}	

	// Initilize the webelements locators values using FINDBY class	

	@FindBy(xpath= ObjectRepository.empDetailsTableXpath)
	@CacheLookup
	List<WebElement> empDetailsTable;

	@FindBy(xpath= ObjectRepository.recordTableXpath) 
	@CacheLookup
	WebElement recordsTable;

	public void getAllEmployeeDetails() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(recordsTable));
		List<WebElement> employeeList = empDetailsTable;
		int totalEmployee=employeeList.size();
		Reporter.log("Number of employee:" +totalEmployee);
		List<String> employeeData = new ArrayList<>();
		for (int i=0; i<totalEmployee;i++){
			Reporter.log("Employee details:" + employeeList.get(i).getText());
			employeeData.add(employeeList.get(i).getText());
			Reporter.log("*********************************");
		}
	}

	public void scrollToEmployeeDetailsUsingID(String ID) {
		//Creating dynamic xpath
		String employeeIDXpath=ObjectRepository.employeeIDXpath.replace("empID", ID);
		WebElement employeeID=driver.findElement(By.xpath(employeeIDXpath));
		Actions actions = new Actions(driver);		
		actions.moveToElement(employeeID);
		actions.perform();
		Reporter.log("Page scrolled to employee details whose id is: "+ID);

	}

	public void selectEmployeeDetailsCheckBox(String ID) {
		//Creating dynamic xpath
		String employeeDetailsCheckboxXpath=ObjectRepository.checkBoxUsingIDXpath.replace("empID", ID);
		WebElement employeeDetailsCheckbox=driver.findElement(By.xpath(employeeDetailsCheckboxXpath));
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(employeeDetailsCheckbox));
		if (employeeDetailsCheckbox.isSelected()) {
			Reporter.log("Checkbox of employee whose id is "+ID+" already selected");
		} else {
			employeeDetailsCheckbox.click();
			Reporter.log("Checkbox of employee whose id is "+ID+" selected");
		}
	}

	public void clickEditButton(String ID) {
		//Creating dynamic xpath
		String editButtonUsingIDXpath=ObjectRepository.editButtonUsingIDXpath.replace("empID", ID);
		WebElement editButton=driver.findElement(By.xpath(editButtonUsingIDXpath));
		editButton.click();
		Reporter.log("Edit button clicked for employee whose id is "+ID+" is clicked");
	}
}
