package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.orangehrm.objectrepository.ObjectRepository;

public class LoginPage {
	WebDriver driver;	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}	

	// Initilize the webelements locators values using FINDBY class	
	@FindBy(xpath= ObjectRepository.userNameXpath) 
	@CacheLookup
	WebElement userName;		

	@FindBy(xpath= ObjectRepository.passwordXpath) 
	@CacheLookup
	WebElement password;	

	@FindBy(xpath= ObjectRepository.loginBtnXpath) 
	@CacheLookup
	WebElement loginBtn;	

	// Reusable methods
	public void enterUserName(String username) {
		userName.sendKeys(username);
		Reporter.log("Username Entered: " + username);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
		Reporter.log("Pssword Entered");
	}

	public void clickLoginBtn() {
		loginBtn.click();
		Reporter.log("Login button clicked ");
	}
}
