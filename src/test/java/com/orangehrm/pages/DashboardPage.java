package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.orangehrm.objectrepository.ObjectRepository;

public class DashboardPage {
	WebDriver driver;	

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath= ObjectRepository.adminTabXpath) 
	@CacheLookup
	WebElement adminTab;
	
	@FindBy(xpath= ObjectRepository.timeLinkXpath) 
	@CacheLookup
	WebElement timeLink;

	@FindBy(xpath= ObjectRepository.profileDropDownArrowXpath) 
	@CacheLookup
	WebElement profileDropDown;

	@FindBy(xpath= ObjectRepository.logoutLinkXpath) 
	@CacheLookup
	WebElement logoutLink;

	@FindBy(xpath= ObjectRepository.myInfoTabXpath) 
	@CacheLookup
	WebElement myInfoTab;

	@FindBy(xpath= ObjectRepository.pimTabXpath) 
	@CacheLookup
	WebElement pimTab;

	public void clickAdminTab() {
		adminTab.click();
		Reporter.log("Admin tab clicked");		
	}

	public void clickProfileDropDown() {
		profileDropDown.click();
		Reporter.log("Profile drop down link clicked");
	}

	public void clickLogoutLink() {
		logoutLink.click();
		Reporter.log("Logout link clicked");
	}

	public void clickMyInfoTab() {
		myInfoTab.click();
		Reporter.log("My Info tab clicked");
	}

	public void clickPIMTab() {
		pimTab.click();
		Reporter.log("PIM tab clicked");		
	}
	
	public void clickTimeLink() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(timeLink));
		timeLink.click();
		Reporter.log("Time link clicked");
	}
}


