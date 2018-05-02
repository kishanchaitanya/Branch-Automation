package com.branch.business;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.branch.page.BranchTeamPage;

public class BranchTeamBusiness extends BranchTeamPage{

	public BranchTeamBusiness(WebDriver driver) {
		super(driver);
	}
	
	public void googleSearchFor(String googleSearchBox){
		getGoogleSearchBox().sendKeys(googleSearchBox);
		getGoogleSearchBox().sendKeys(Keys.RETURN);
	}
	
	public void openBranchWebsite(){
		getBranchWebsite().click();
		goToBranchFootNotes();
	}
	
	public void navigateToBranchTeam(){
		getTeamLink().click();
	}
	
	public void navigateToAllDepartmentTabs(){
		navigateAllTabs();
	}
	
	public void verifyNumberOfEmployees(){
		validateNumberOfTeamMembers();
	}
	
	public void verifyEmployeeNames(){
		validateEmployeeNames();
	}
	
	public void verifyEmployeeDepartments(){
		validateEmployeeDepartments();
	}
	
	public void verifyEmployeePhotos(){
		validateEmployeePhotos();
	}
	
	public void verifyEmployeeDescriptions(){
		validateEmployeeDescriptions();
	}
	
	public void verifyProperDepartmentName(){
		validateProperDepartments();
	}

}
