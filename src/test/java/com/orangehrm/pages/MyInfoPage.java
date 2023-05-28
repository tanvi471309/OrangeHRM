package com.orangehrm.pages;

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

public class MyInfoPage {
	WebDriver driver;	

	public MyInfoPage(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(xpath= ObjectRepository.firstNameTextBoxXpath ) 
	@CacheLookup
	WebElement firstNameTextBox;
	
	@FindBy(xpath= ObjectRepository.middleNameTextBoxXpath ) 
	@CacheLookup
	WebElement middleNameTextBox;
	
	@FindBy(xpath= ObjectRepository.lastNameTextBoxXpath) 
	@CacheLookup
	WebElement lastNameTextBox;
	
	@FindBy(xpath= ObjectRepository.nickNameTextBoxXpath) 
	@CacheLookup
	WebElement nickNameTextBox;
	
	@FindBy(xpath= ObjectRepository.employeeIDTextBoxXpath) 
	@CacheLookup
	WebElement employeeIDTextBox;
	
	@FindBy(xpath= ObjectRepository.otherIDTextBoxXpath) 
	@CacheLookup
	WebElement otherIDTextBox;
	
	@FindBy(xpath= ObjectRepository.driverLicenseNumTextBoxXpath) 
	@CacheLookup
	WebElement driverLicenseNumTextBox;
	
	@FindBy(xpath= ObjectRepository.ssnNumTextBoxXpath) 
	@CacheLookup
	WebElement ssnNumTextBox;
	
	@FindBy(xpath= ObjectRepository.sinNumTextBoxXpath) 
	@CacheLookup
	WebElement sinNumTextBox;
	
	@FindBy(xpath= ObjectRepository.smokerCheckBoxXpath) 
	@CacheLookup
	WebElement smokerCheckBox;
	
	@FindBy(xpath= ObjectRepository.saveMyInfoButtonXpath) 
	@CacheLookup
	WebElement saveButton;
	
	@FindBy(xpath= ObjectRepository.nationalityDropDownArrowXpath) 
	@CacheLookup
	WebElement nationalityDropDownArrow;
	
	@FindBy(xpath= ObjectRepository.maritalStatusDropDownArrowXpath) 
	@CacheLookup
	WebElement maritalStatusDropDownArrow;
	
	@FindBy(xpath= ObjectRepository.genderMaleRadioButtonXpath) 
	@CacheLookup
	WebElement genderMaleRadio;
	
	@FindBy(xpath= ObjectRepository.genderFemaleRadioButtonXpath) 
	@CacheLookup
	WebElement genderFemaleRadio;
		
	public void enterFirstName(String firstName) {	
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(firstNameTextBox));
		firstNameTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		firstNameTextBox.sendKeys(firstName);
		Reporter.log("First name entered: "+firstName);
	}
	public void enterMiddleName(String middleName) {
		middleNameTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		middleNameTextBox.clear();
		middleNameTextBox.sendKeys(middleName);
		Reporter.log("Middle name entered: "+middleName);
	}
	public void enterLastName(String lastName) {
		lastNameTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		lastNameTextBox.clear();
		lastNameTextBox.sendKeys(lastName);
		Reporter.log("Last name entered: "+lastName);
	}
	public void enterNickName(String nickName) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(nickNameTextBox));
		nickNameTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		nickNameTextBox.sendKeys(nickName);
		Reporter.log("Nick name entered: "+nickName);
	}
	public void enterEmployeeID(String employeeID) {		
		employeeIDTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		employeeIDTextBox.sendKeys(employeeID);
		Reporter.log("Employee ID entered: "+employeeID);
	}
	public void enterOtherID(String otherID) {
		otherIDTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		otherIDTextBox.sendKeys(otherID);
		Reporter.log("Other ID entered: "+otherID);
	}
	public void enterDriverLicenseNum(String licenseNumber) {
		driverLicenseNumTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		driverLicenseNumTextBox.sendKeys(licenseNumber);
		Reporter.log("Driver License Number entered: "+licenseNumber);
	}
	public void enterSSNNum(String ssnNumber) {
		ssnNumTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		ssnNumTextBox.sendKeys(ssnNumber);
		Reporter.log("SSN Number entered: "+ssnNumber);
	}
	
	public void selectNationality(String nationality) {
		Actions actions = new Actions(driver);		
	    actions.moveToElement(nationalityDropDownArrow);
	    Reporter.log("Scrolled to Nationality");
		nationalityDropDownArrow.click();
		Reporter.log("Clicked on Nationality drop down");
		//Creating dynamic xpath
		String nationalityXpath=ObjectRepository.nationalityIndianXpath.replace("country",nationality);
		WebElement nationalityOption=driver.findElement(By.xpath(nationalityXpath));
		actions.moveToElement(nationalityOption);
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(nationalityOption));
		nationalityOption.click();
		Reporter.log("Nationality selected: "+nationality);
	}
	public void selectMaritalStatus(String maritalStatus) {
		Actions actions = new Actions(driver);		
	    actions.moveToElement(maritalStatusDropDownArrow);
	    Reporter.log("Scrolled to Marital Status");
		maritalStatusDropDownArrow.click();
		Reporter.log("Clicked on Marital Status drop down");
		
		//Creating dynamic xpath
		String maritalStatusXpath=ObjectRepository.maritalStatusSingleXpath.replace("maritalStatus",maritalStatus);
		WebElement maritalStatusOption=driver.findElement(By.xpath(maritalStatusXpath));
		actions.moveToElement(maritalStatusOption);
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(maritalStatusOption));
		maritalStatusOption.click();
		Reporter.log("Marital status selected: "+maritalStatus);
	}
	public void enterSINNum(String sinNumber) {
		sinNumTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		sinNumTextBox.clear();
		sinNumTextBox.sendKeys(sinNumber);
		Reporter.log("SIN Number entered: "+sinNumber);
	}
	public void selectSmokerCheckBox() {
		Actions actions = new Actions(driver);		
		actions.moveToElement(smokerCheckBox);
		smokerCheckBox.click();
		Reporter.log("Smoker check box selected");
	}	
	public void selectGender(String gender){
		if (gender.equalsIgnoreCase("Male")) {
			Actions actions = new Actions(driver);		
			actions.moveToElement(genderMaleRadio);
			genderMaleRadio.click();
			Reporter.log("Gender selected: "+gender);
		} else {
			Actions actions = new Actions(driver);		
			actions.moveToElement(genderFemaleRadio);
			genderFemaleRadio.click();
			Reporter.log("Gender selected: "+gender);
		}		
	}
	public void clickSaveButton() {
		Actions actions = new Actions(driver);		
		actions.moveToElement(saveButton);
		saveButton.click();
		Reporter.log("Save button clicked");
	}
}
