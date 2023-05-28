package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.orangehrm.objectrepository.ObjectRepository;

public class TimePage {

	WebDriver driver;	

	public TimePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath= ObjectRepository.timesheetTabXpath ) 
	@CacheLookup
	WebElement timesheetTab;

	@FindBy(xpath= ObjectRepository.myTimesheetDropDownOptionXpath ) 
	@CacheLookup
	WebElement myTimesheetDropDownOption;

	@FindBy(xpath= ObjectRepository.editButtonXpath ) 
	@CacheLookup
	WebElement editButton;

	@FindBy(xpath= ObjectRepository.projectTextBoxXpath ) 
	@CacheLookup
	WebElement projectTextBox;

	@FindBy(xpath= ObjectRepository.projectOptionXpath ) 
	@CacheLookup
	WebElement projectOption;

	@FindBy(xpath= ObjectRepository.activityDropDownArrowXpath ) 
	@CacheLookup
	WebElement activityDropDownArrow;

//	@FindBy(xpath= ObjectRepository.trainingProgramCreationOptionXpath ) 
//	@CacheLookup
//	WebElement trainingProgramCreationOption;	

	@FindBy(xpath= ObjectRepository.timesheetTableXpath ) 
	@CacheLookup
	WebElement timesheetTable;	

	@FindBy(xpath= ObjectRepository.tableRecordsXpath ) 
	@CacheLookup
	List<WebElement> tableRecords;

	@FindBy(xpath= ObjectRepository.weekDaysColumnXpath ) 
	@CacheLookup
	List<WebElement> weekDaysColumn;
	
	@FindBy(xpath= ObjectRepository.saveTimesheetButtonXpath ) 
	@CacheLookup
	WebElement saveTimesheetButton;
	
	public void clickTimesheetTab() {
		timesheetTab.click();
		Reporter.log("Timesheet tab clicked");
	}

	public void clickMyTimesheetOption() {
		myTimesheetDropDownOption.click();
		Reporter.log("Time sheet option selected");
	}

	public void clickEditButton() {
		editButton.click();
		Reporter.log("Edit button clicked");
	}

	public void clickProjectTextBox(String projectName){
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(projectTextBox));
		projectTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);		
		projectTextBox.sendKeys(projectName);
		Reporter.log("Entered project name: "+projectName);
	}
	public void selectProjectName() {	
		WebDriverWait wait = new WebDriverWait(driver,150);
		wait.until(ExpectedConditions.visibilityOf(projectOption));
		Actions actions = new Actions(driver);		
		actions.moveToElement(projectOption);
		projectOption.click();
		Reporter.log("Project name selected from given options");
	}
	public void clickActivityDropDown() {
		activityDropDownArrow.click();
		Reporter.log("Activity drop down clicked");
	}
	public void selectActivity() {
		//Creating dynamic xpath
		String activityOptionXpath=ObjectRepository.activityOptionXpath.replace("Activity", "Implementation");
		WebElement activityOption=driver.findElement(By.xpath(activityOptionXpath));
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(activityOption));
		activityOption.click();
		Reporter.log("Activity selected");
	}

	public void fillTimesheetTable(String time) {
		if (timesheetTable.isDisplayed()) {
			Reporter.log("Timesheet table displayed");
		}		
		int totalProjects=tableRecords.size()-1;
		Reporter.log("Total number of project: "+totalProjects);
		for(int record=0;record<totalProjects;record++ )
		{
			int weekDaysCells=weekDaysColumn.size();
			for(int columnNum=2;columnNum<weekDaysCells;columnNum++)
			{										
				String rowFoundXpath ="(//div[@class='oxd-input-group__label-wrapper']//following-sibling::div//input)"+"["+columnNum+"]";
				WebElement workingDaysCell=driver.findElement(By.xpath(rowFoundXpath));
				workingDaysCell.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
				workingDaysCell.sendKeys(time);				
			}
			Reporter.log("Time entered in timesheet");
		}
	}
	
	public void clickSaveButton() {
		saveTimesheetButton.click();
		Reporter.log("Save button clicked");
	}
	
	
}

