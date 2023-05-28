package com.orangehrm.objectrepository;

/*
 * All the locators values are mentioned here
 * 
 * Naming Rule:
 * For link and partial link text locator => add Link as suffix 
 * 
 * Rest of the locators use relative xpath tricks
 * 
 * 
 */

public class ObjectRepository {	

	// Object Repository of Orange HRM
	
		// Login Page 
		public static final String userNameXpath = "//input[@placeholder='Username']";
		public static final String passwordXpath = "//input[@placeholder='Password']";
		public static final String loginBtnXpath = "//button[normalize-space()='Login']";

		// Dashboard Page
		public static final String adminTabXpath = "(//ul[@class='oxd-main-menu']//child::span)[1]";
		public static final String myInfoTabXpath = "(//ul[@class='oxd-main-menu']//child::span)[6]";
		public static final String pimTabXpath = "(//ul[@class='oxd-main-menu']//child::span)[2]";
		public static final String profileDropDownArrowXpath="//span[@class='oxd-userdropdown-tab']";
		public static final String logoutLinkXpath="//a[normalize-space()='Logout']";
		public static final String timeLinkXpath="(//ul[@class='oxd-main-menu']//child::span)[4]";
		
		// My Info Page
		public static final String firstNameTextBoxXpath = "//input[@name='firstName']";
		public static final String middleNameTextBoxXpath = "//input[@placeholder='Middle Name']";
		public static final String lastNameTextBoxXpath = "//input[@placeholder='Last Name']";
		public static final String nickNameTextBoxXpath = "(//div[@class='oxd-input-group__label-wrapper'])[5]//following-sibling::div//child::input";
		public static final String employeeIDTextBoxXpath = "(//div[@class='oxd-input-group__label-wrapper'])[6]//following-sibling::div//child::input";
		public static final String otherIDTextBoxXpath = "(//div[@class='oxd-input-group__label-wrapper'])[7]//following-sibling::div//child::input";
		public static final String driverLicenseNumTextBoxXpath = "(//div[@class='oxd-input-group__label-wrapper'])[8]//following-sibling::div//child::input";
		public static final String ssnNumTextBoxXpath = "(//div[@class='oxd-input-group__label-wrapper'])[10]//following-sibling::div//child::input";
		public static final String sinNumTextBoxXpath = "(//div[@class='oxd-input-group__label-wrapper'])[11]//following-sibling::div//child::input";
		public static final String smokerCheckBoxXpath = "//label[normalize-space()='Yes']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']";
		public static final String saveMyInfoButtonXpath = "(//button[@type='submit'][normalize-space()='Save'])[1]";
		public static final String genderMaleRadioButtonXpath="(//div[@class='oxd-input-group__label-wrapper'])[15]//following-sibling::div//child::input";
		public static final String genderFemaleRadioButtonXpath="(//div[@class='oxd-input-group__label-wrapper'])[17]//following-sibling::div//child::input";
		public static final String nationalityDropDownArrowXpath="(//div[@class='oxd-select-text--after'])[1]";
		public static final String nationalityIndianXpath="//div[@role='listbox']//div//*[contains(text(),'country')]";
		public static final String maritalStatusDropDownArrowXpath="(//div[@class='oxd-select-text--after'])[2]";
		public static final String maritalStatusSingleXpath="//div[@role='listbox']//div//*[contains(text(),'maritalStatus')]";

		//TimeSheet Page
		public static final String timesheetTabXpath="//span[normalize-space()='Timesheets']//i[@class='oxd-icon bi-chevron-down']";
//		//public static final String employeeNameXpath="(//div[@class='oxd-table-row oxd-table-row--with-border']//child::div[contains(text(),'Charlie  Carter')])[1]";
//	//	public static final String viewButtonXpath="(//div[@class='oxd-table-row oxd-table-row--with-border']//child::div[contains(text(),'Charlie  Carter')])[1]//following::div[3]//button";
		public static final String editButtonXpath="//button[@type='button' and normalize-space()='Edit']";
		public static final String myTimesheetDropDownOptionXpath="//a[normalize-space()='My Timesheets']";
		public static final String projectTextBoxXpath="//input[@placeholder='Type for hints...']";
		public static final String projectOptionXpath="//div[@class='oxd-autocomplete-option']//span";
		public static final String activityDropDownArrowXpath="//div[@class='oxd-select-text--after']//child::i";
		public static final String activityOptionXpath="//div[@class='oxd-select-option']//span[contains(text(),'Activity')]";
		public static final String timesheetTableXpath="//table[@class='orangehrm-timesheet-table --editable']";
		public static final String tableRecordsXpath="//tr[@class='orangehrm-timesheet-table-body-row']";
		public static final String weekDaysColumnXpath="//td[@class='orangehrm-timesheet-table-body-cell --center --duration-input']";
		public static final String saveTimesheetButtonXpath="//button[@type='submit']";

		//PIM Page
		public static final String empDetailsTableXpath = "//div[@class='oxd-table-card']";
		public static final String employeeIDXpath = "//div[@class='oxd-table-cell oxd-padding-cell']//child::div[contains(text(),'empID')]";
		public static final String checkBoxUsingIDXpath = "//div[contains(text(),'empID')]//parent::div//preceding-sibling::div//child::label";
		public static final String editButtonUsingIDXpath = "//div[contains(text(),'empID')]//parent::div//following-sibling::div[7]//child::button[2]";
				
		//User Management Page
		public static final String addButtonXpath = "//button[normalize-space()='Add']";
		public static final String searchUserRoleDropDownArrowXpath = "(//*[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]";
		public static final String searchUserRoleAdminXpath = "//div[@role='listbox']//div//*[contains(text(),'Admin')]";
		public static final String searchUserRoleESSXpath = "//div[@role='listbox']//div//*[contains(text(),'ESS')]";
		public static final String searchEmployeeNameTextBoxXpath = "//input[@placeholder='Type for hints...']";
		public static final String searchEmployeeNameFromListXpath = "//div[@role='listbox']//div//*[contains(text(),'EmpName')]";
		public static final String searchStatusDropDownArrowXpath = "(//*[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]";
		public static final String searchStatusEnabledXpath = "//div[@role='listbox']//div//*[contains(text(),'Enabled')]";
		public static final String searchStatusDisabledXpath = "//div[@role='listbox']//div//*[contains(text(),'Disabled')]";
		public static final String searchUsernameTextBoxXpath = "(//label[normalize-space()='Username']//parent::div//following::div//child::input)[1]";
		public static final String searchButtonXpath="//button[@type='submit']";		
		public static final String searchRecordXpath="//div[@class='oxd-table-row oxd-table-row--with-border']";
		public static final String recordTableXpath="//div[@class='oxd-table-body']";
		public static final String SystemUsersHeadingXpath="//div[@class='oxd-table-filter']//H5";
		
		//Save System User Page
		public static final String userRoleDropDownArrowXpath = "(//*[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]";
		public static final String userRoleAdminXpath = "//div[@role='listbox']//div//*[contains(text(),'Admin')]";
		public static final String userRoleESSXpath = "//div[@role='listbox']//div//*[contains(text(),'ESS')]";
		public static final String employeeNameTextBoxXpath = "//input[@placeholder='Type for hints...']";
		public static final String employeeNameFromListXpath = "//div[@role='listbox']//div//*[contains(text(),'EmpName')]";
		public static final String statusDropDownArrowXpath = "(//*[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]";
		public static final String statusEnabledXpath = "//div[@role='listbox']//div//*[contains(text(),'Enabled')]";
		public static final String statusDisabledXpath = "//div[@role='listbox']//div//*[contains(text(),'Disabled')]";
		public static final String usernameTextBoxXpath = "(//label[normalize-space()='Username']//parent::div//following::div//child::input)[1]";
		public static final String newUserPasswordTextBoxXpath = "(//label[normalize-space()='Username']//parent::div//following::div//child::input)[2]";
		public static final String confirmPasswordTextBoxXpath = "(//label[normalize-space()='Username']//parent::div//following::div//child::input)[3]";
		public static final String saveButtonXpath="//button[@type='submit']";

}
