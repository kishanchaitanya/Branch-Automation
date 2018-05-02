package com.branch.regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.branch.Base;
import com.branch.business.BranchTeamBusiness;

public class BranchTeamRegression {
	
	Base base = new Base();
	WebDriver driver = base.getDriver(); 
	BranchTeamBusiness branch = PageFactory.initElements(driver, BranchTeamBusiness.class);
	
	@BeforeTest
	public void init() {
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		branch.googleSearchFor("branch.io");
		branch.openBranchWebsite();
		branch.navigateToBranchTeam();
		branch.navigateToAllDepartmentTabs();
	}
	
	@Test(priority = 1, description = "Verify that number of employees match between All tab and sum of other tabs.")
	public void verifyNumberOfEmployees() {
		branch.verifyNumberOfEmployees();
	}
	
	@Test(priority = 2, description = "Verify that employee names match between All tab and other tabs.")
	public void verifyEmployeeNames() {
		branch.verifyEmployeeNames();
	}
	
	@Test(priority = 3, description = "Verify that employee departments are listed correctly between All tab and Department tabs.")
	public void verifyEmployeeDepartments() {
		branch.verifyEmployeeDepartments();
	}
	
	@Test(priority = 4, description = "Verify that employee photos are listed correctly between All tab and Department tabs.")
	public void verifyEmployeePhotos() {
		branch.verifyEmployeePhotos();
	}
	
	@Test(priority = 5, description = "Verify that employee descriptions are listed correctly between All tab and Department tabs.")
	public void verifyEmployeeDescriptions() {
		branch.verifyEmployeeDescriptions();
	}
	
	@Test(priority = 6, description = "Verify that the proper department name is listed under each tab")
	public void verifyProperDepartmentName() {
		branch.verifyProperDepartmentName();
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
}
