package com.branch.page;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.branch.Base;

public class BranchTeamPage extends Base{
	public WebDriver driver;
	public BranchTeamPage(WebDriver driver){
		this.driver = driver;
	}
	
	public By googleSearchBox = By.id("lst-ib");
	public By branchWebSite = By.linkText("Branch.io");
	public By bottomFootNotes = By.className("footer-inner");
	public By teamLink = By.linkText("Team");
	
	List<WebElement> allMembers = null;
	List<WebElement> dataMembers = null;
	List<WebElement> engineeringMembers = null;
	List<WebElement> marketingMembers = null;
	List<WebElement> operationsMembers = null;
	List<WebElement> partnerGrowthMembers = null;
	List<WebElement> productMembers = null;
	List<WebElement> recruitingMembers = null;
	
	List<String> allTabEmployeeNames = new ArrayList<String>();
	List<String> allDepartmentTabEmployeeNames = new ArrayList<String>();
	
	List<String> allEmployeeDepartments = new ArrayList<String>();
	List<String> allDepartmentEmployeeDepartmentNames = new ArrayList<String>();
	Map<String, String> allEmployeeMapForNameandDept = new Hashtable<String, String>();
	Map<String, String> allDeptMapforNameAndDept = new Hashtable<String, String>();

	List<String> allEmployeePhotos = new ArrayList<String>();
	List<String> allDepartmentEmployeeNames = new ArrayList<String>();
	List<String> allDepartmentEmployeePhotos = new ArrayList<String>();
	Map<String, String> allEmployeeMapForNameandPhoto = new Hashtable<String, String>();
	Map<String, String> allDepartmenteMapForNameandPhoto = new Hashtable<String, String>();
	
	List<String> allEmployeeDescriptions = new ArrayList<String>();
	List<String> allDepartmentEmployeeDescription = new ArrayList<String>();
	Map<String, String> allEmployeeMapForNameandDescription = new Hashtable<String, String>();
	Map<String, String> allDepartmenteMapForNameandDescription = new Hashtable<String, String>();
	
	int departmentcount = 0;
	
	int allMembersSize = 0;
	int dataMembersSize = 0;
	int engineeringMembersSize = 0;
	int marketingMembersSize = 0;
	int operationsMembersSize = 0;
	int partnerGrowthMembersSize = 0;
	int productMembersSize = 0;
	int recruitingMembersSize = 0;
	
	public WebElement getGoogleSearchBox(){
		return driver.findElement(googleSearchBox);
	}
	
	public WebElement getBranchWebsite(){
		return driver.findElement(branchWebSite);
	}
	
	public void goToBranchFootNotes(){
		WebElement element = driver.findElement(bottomFootNotes);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}
	
	public WebElement getTeamLink(){
		return driver.findElement(teamLink);
	}
	
	public void navigateAllTabs(){
		
		// ALL TAB
		driver.findElement(By.linkText("ALL")).click();		
		allMembers = driver.findElements(By.className("category-all"));
		for (WebElement member : allMembers) {
			if(member.getAttribute("style").equals("display: inline-block;")){
				allMembersSize = allMembersSize + 1;	
			}
		}
		List<WebElement> allEmployees = driver.findElements(By.cssSelector(".category-all .info-block h2"));
		for (WebElement element : allEmployees) {
			allTabEmployeeNames.add(element.getText());
		}
		
		List<WebElement> allEmployeeDepartmentsWE = driver.findElements(By.cssSelector(".category-all .info-block h4"));
		for (WebElement element : allEmployeeDepartmentsWE) {
			allEmployeeDepartments.add(element.getText());
		}
		for (int i=0; i<allTabEmployeeNames.size(); i++) {
			allEmployeeMapForNameandDept.put(allTabEmployeeNames.get(i), allEmployeeDepartments.get(i));
		}
		
		List<WebElement> employeePhotosWE = driver.findElements(By.cssSelector(".category-all .image-block"));	
		for (WebElement element : employeePhotosWE) {
			allEmployeePhotos.add(element.getAttribute("style"));
		}
		for (int i=0; i<allTabEmployeeNames.size(); i++) {
			allEmployeeMapForNameandPhoto.put(allTabEmployeeNames.get(i), allEmployeePhotos.get(i));
		}
		
		List<WebElement> allEmployeeDescriptionsWE = driver.findElements(By.cssSelector(".category-all .overlay p"));
		for (WebElement element : allEmployeeDescriptionsWE) {
			allEmployeeDescriptions.add(element.getAttribute("innerHTML"));
		}
		for (int i=0; i<allTabEmployeeNames.size(); i++) {
			allEmployeeMapForNameandDescription.put(allTabEmployeeNames.get(i), allEmployeeDescriptions.get(i));
		}
		
		// DATA TAB
		driver.findElement(By.linkText("DATA")).click();
		dataMembers = driver.findElements(By.className("category-data"));
		for (WebElement member : dataMembers) {
			if(member.getAttribute("style").equals("display: inline-block;")){
				dataMembersSize = dataMembersSize + 1;	
			}
		}
		List<WebElement> dataEmployees = driver.findElements(By.cssSelector(".category-data .info-block h2"));
		for (WebElement element : dataEmployees) {
			allDepartmentTabEmployeeNames.add(element.getText());
		}	
		
		List<WebElement> dataEmployeeDepartments = driver.findElements(By.cssSelector(".category-data .info-block h4"));
		for (WebElement element : dataEmployeeDepartments) {
			allDepartmentEmployeeDepartmentNames.add(element.getText());
			if(element.getText().equals("Data")){
				departmentcount = departmentcount + 1;
			}
		}
		
		List<WebElement> dataEmployeeDepartmentPhotos = driver.findElements(By.cssSelector(".category-data .image-block"));
		for (WebElement element : dataEmployeeDepartmentPhotos) {
			allDepartmentEmployeePhotos.add(element.getAttribute("style"));
		}
		
		List<WebElement> dataEmployeeDepartmentDescriptions = driver.findElements(By.cssSelector(".category-data .overlay p"));
		for (WebElement element : dataEmployeeDepartmentDescriptions) {
			allDepartmentEmployeeDescription.add(element.getAttribute("innerHTML"));
		}
		
		// ENGINEERING TAB
		driver.findElement(By.linkText("ENGINEERING")).click();
		engineeringMembers = driver.findElements(By.className("category-engineering"));
		for (WebElement member : engineeringMembers) {
			if(member.getAttribute("style").equals("display: inline-block;")){
				engineeringMembersSize = engineeringMembersSize + 1;	
			}
		}
		List<WebElement> engineeringEmployees = driver.findElements(By.cssSelector(".category-engineering .info-block h2"));
		for (WebElement element : engineeringEmployees) {
			allDepartmentTabEmployeeNames.add(element.getText());
		}
		
		List<WebElement> engineeringEmployeeDepartments = driver.findElements(By.cssSelector(".category-engineering .info-block h4"));
		for (WebElement element : engineeringEmployeeDepartments) {
			allDepartmentEmployeeDepartmentNames.add(element.getText());
			if(element.getText().equals("Engineering") || element.getText().equals("Co-Founder / CEO") || element.getText().equals("Co-Founder / Engineering")){
				departmentcount = departmentcount + 1;
			}
		}
		
		List<WebElement> engineeringEmployeeDepartmentPhotos = driver.findElements(By.cssSelector(".category-engineering .image-block"));
		for (WebElement element : engineeringEmployeeDepartmentPhotos) {
			allDepartmentEmployeePhotos.add(element.getAttribute("style"));
		}
		
		List<WebElement> engineeringEmployeeDepartmentsDescriptions = driver.findElements(By.cssSelector(".category-engineering .overlay p"));
		for (WebElement element : engineeringEmployeeDepartmentsDescriptions) {
			allDepartmentEmployeeDescription.add(element.getAttribute("innerHTML"));
		}
		
		// MARKETING TAB
		driver.findElement(By.linkText("MARKETING")).click();
		marketingMembers = driver.findElements(By.className("category-marketing"));
		for (WebElement member : marketingMembers) {
			if(member.getAttribute("style").equals("display: inline-block;")){
				marketingMembersSize = marketingMembersSize + 1;	
			}
		}
		List<WebElement> marketingEmployees = driver.findElements(By.cssSelector(".category-marketing .info-block h2"));
		for (WebElement element : marketingEmployees) {
			allDepartmentTabEmployeeNames.add(element.getText());
		}
		
		List<WebElement> marketingEmployeeDepartments = driver.findElements(By.cssSelector(".category-marketing .info-block h4"));
		for (WebElement element : marketingEmployeeDepartments) {
			allDepartmentEmployeeDepartmentNames.add(element.getText());
			if(element.getText().equals("Marketing") || element.getText().equals("Co-Founder / Marketing")){
				departmentcount = departmentcount + 1;
			}
		}
		
		List<WebElement> marketingEmployeeDepartmentPhotos = driver.findElements(By.cssSelector(".category-marketing .image-block"));
		for (WebElement element : marketingEmployeeDepartmentPhotos) {
			allDepartmentEmployeePhotos.add(element.getAttribute("style"));
		}
		
		List<WebElement> marketingEmployeeDepartmentsDescriptions = driver.findElements(By.cssSelector(".category-marketing .overlay p"));
		for (WebElement element : marketingEmployeeDepartmentsDescriptions) {
			allDepartmentEmployeeDescription.add(element.getAttribute("innerHTML"));
		}
		
		// OPERATIONS TAB
		driver.findElement(By.linkText("OPERATIONS")).click();
		operationsMembers = driver.findElements(By.className("category-operations"));
		for (WebElement member : operationsMembers) {
			if(member.getAttribute("style").equals("display: inline-block;")){
				operationsMembersSize = operationsMembersSize + 1;	
			}
		}
		List<WebElement> operationsEmployees = driver.findElements(By.cssSelector(".category-operations .info-block h2"));
		for (WebElement element : operationsEmployees) {
			allDepartmentTabEmployeeNames.add(element.getText());
		}
		
		List<WebElement> operationsEmployeeDepartments = driver.findElements(By.cssSelector(".category-operations .info-block h4"));
		for (WebElement element : operationsEmployeeDepartments) {
			allDepartmentEmployeeDepartmentNames.add(element.getText());
			if(element.getText().equals("Operations")){
				departmentcount = departmentcount + 1;
			}
		}
		
		List<WebElement> operationsEmployeeDepartmentPhotos = driver.findElements(By.cssSelector(".category-operations .image-block"));
		for (WebElement element : operationsEmployeeDepartmentPhotos) {
			allDepartmentEmployeePhotos.add(element.getAttribute("style"));
		}
		
		List<WebElement> operationsEmployeeDepartmentsDescriptions = driver.findElements(By.cssSelector(".category-operations .overlay p"));
		for (WebElement element : operationsEmployeeDepartmentsDescriptions) {
			allDepartmentEmployeeDescription.add(element.getAttribute("innerHTML"));
		}
		
		// PARTNER GROWTH TAB
		driver.findElement(By.linkText("PARTNER GROWTH")).click();
		partnerGrowthMembers = driver.findElements(By.className("category-partner-growth"));
		for (WebElement member : partnerGrowthMembers) {
			if(member.getAttribute("style").equals("display: inline-block;")){
				partnerGrowthMembersSize = partnerGrowthMembersSize + 1;	
			}
		}
		List<WebElement> partnerGrowthEmployees = driver.findElements(By.cssSelector(".category-partner-growth .info-block h2"));
		for (WebElement element : partnerGrowthEmployees) {
			allDepartmentTabEmployeeNames.add(element.getText());
		}
		
		List<WebElement> partnerGrowthEmployeeDepartments = driver.findElements(By.cssSelector(".category-partner-growth .info-block h4"));
		for (WebElement element : partnerGrowthEmployeeDepartments) {
			allDepartmentEmployeeDepartmentNames.add(element.getText());
			if(element.getText().equals("Partner Growth") || element.getText().equals("Partner growth") || element.getText().equals("Co-Founder / COO")){
				departmentcount = departmentcount + 1;
			}
		}
		
		List<WebElement> partnerGrowthEmployeeDepartmentPhotos = driver.findElements(By.cssSelector(".category-partner-growth .image-block"));
		for (WebElement element : partnerGrowthEmployeeDepartmentPhotos) {
			allDepartmentEmployeePhotos.add(element.getAttribute("style"));
		}
		
		List<WebElement> partnerGrowthEmployeeDepartmentDescriptions = driver.findElements(By.cssSelector(".category-partner-growth .overlay p"));
		for (WebElement element : partnerGrowthEmployeeDepartmentDescriptions) {
			allDepartmentEmployeeDescription.add(element.getAttribute("innerHTML"));
		}
		
		// PRODUCT TAB
		driver.findElement(By.linkText("PRODUCT")).click();
		productMembers = driver.findElements(By.className("category-product"));
		for (WebElement member : productMembers) {
			if(member.getAttribute("style").equals("display: inline-block;")){
				productMembersSize = productMembersSize + 1;	
			}
		}
		List<WebElement> productEmployees = driver.findElements(By.cssSelector(".category-product .info-block h2"));
		for (WebElement element : productEmployees) {
			allDepartmentTabEmployeeNames.add(element.getText());
		}
		
		List<WebElement> productEmployeeDepartments = driver.findElements(By.cssSelector(".category-product .info-block h4"));
		for (WebElement element : productEmployeeDepartments) {
			allDepartmentEmployeeDepartmentNames.add(element.getText());
			if(element.getText().equals("Product")){
				departmentcount = departmentcount + 1;
			}
		}
		
		List<WebElement> productEmployeeDepartmentPhotos = driver.findElements(By.cssSelector(".category-product .image-block"));
		for (WebElement element : productEmployeeDepartmentPhotos) {
			allDepartmentEmployeePhotos.add(element.getAttribute("style"));
		}
		
		List<WebElement> productEmployeeDepartmentDescription = driver.findElements(By.cssSelector(".category-product .overlay p"));
		for (WebElement element : productEmployeeDepartmentDescription) {
			allDepartmentEmployeeDescription.add(element.getAttribute("innerHTML"));
		}
		
		// RECRUITING TAB
		driver.findElement(By.linkText("RECRUITING")).click();
		recruitingMembers = driver.findElements(By.className("category-recruiting"));
		for (WebElement member : recruitingMembers) {
			if(member.getAttribute("style").equals("display: inline-block;")){
				recruitingMembersSize = recruitingMembersSize + 1;	
			}
		}
		List<WebElement> recruitingEmployees = driver.findElements(By.cssSelector(".category-recruiting .info-block h2"));
		for (WebElement element : recruitingEmployees) {
			allDepartmentTabEmployeeNames.add(element.getText());
		}
		
		List<WebElement> recruitingEmployeeDepartments = driver.findElements(By.cssSelector(".category-recruiting .info-block h4"));
		for (WebElement element : recruitingEmployeeDepartments) {
			allDepartmentEmployeeDepartmentNames.add(element.getText());
			if(element.getText().equals("Recruiting")){
				departmentcount = departmentcount + 1;
			}
		}
		for (int i=0; i<allDepartmentTabEmployeeNames.size(); i++) {
			allDeptMapforNameAndDept.put(allDepartmentTabEmployeeNames.get(i), allDepartmentEmployeeDepartmentNames.get(i));
		}
		
		List<WebElement> recruitingEmployeeDepartmentPhotos = driver.findElements(By.cssSelector(".category-recruiting .image-block"));
		for (WebElement element : recruitingEmployeeDepartmentPhotos) {
			allDepartmentEmployeePhotos.add(element.getAttribute("style"));
		}
		for (int i=0; i<allDepartmentTabEmployeeNames.size(); i++) {
			allDepartmenteMapForNameandPhoto.put(allDepartmentTabEmployeeNames.get(i), allDepartmentEmployeePhotos.get(i));
		}
		
		List<WebElement> recruitingEmployeeDepartmentDescriptions = driver.findElements(By.cssSelector(".category-recruiting .overlay p"));
		for (WebElement element : recruitingEmployeeDepartmentDescriptions) {
			allDepartmentEmployeeDescription.add(element.getAttribute("innerHTML"));
		}
		for (int i=0; i<allDepartmentTabEmployeeNames.size(); i++) {
			allDepartmenteMapForNameandDescription.put(allDepartmentTabEmployeeNames.get(i), allDepartmentEmployeeDescription.get(i));
		}
	}
	
	public void validateNumberOfTeamMembers(){
		
		int numberOfAllTeamMembers = allMembersSize;		
		int numberOfDepartmentMembers = dataMembersSize + engineeringMembersSize + marketingMembersSize +
										operationsMembersSize + partnerGrowthMembersSize + productMembersSize +
										recruitingMembersSize;
		
		assertTrue(numberOfAllTeamMembers == 129);
		assertTrue(numberOfDepartmentMembers == 125);
	}
	
	public void validateEmployeeNames(){
		
		allTabEmployeeNames.removeAll(allDepartmentTabEmployeeNames);
		
		assertTrue(allTabEmployeeNames.size() == 4);
	}
	
	public void validateEmployeeDepartments(){
		
		int chkcount = 0;
		
		for(Map.Entry<String,String> entry: allDeptMapforNameAndDept.entrySet()){
            String allTab = allEmployeeMapForNameandDept.get(entry.getKey());
            String deptTab = entry.getValue();
            if(allTab != null && deptTab != null && allTab.equals(deptTab)){
                chkcount = chkcount + 1;
            }
        }
		
		assertTrue(chkcount == 125);		

	}
	
	public void validateEmployeePhotos(){
				
		int chkcount = 0;
		
		for(Map.Entry<String,String> entry: allDepartmenteMapForNameandPhoto.entrySet()){
            String allTab = allEmployeeMapForNameandPhoto.get(entry.getKey());
            String deptTab = entry.getValue();
            if(allTab != null && deptTab != null && allTab.equals(deptTab)){
                chkcount = chkcount + 1;
            }
        }
		
		assertTrue(chkcount == 125);		
	
	}
	
	public void validateEmployeeDescriptions(){
		
		int chkcount = 0;
		
		for(Map.Entry<String,String> entry: allDepartmenteMapForNameandDescription.entrySet()){
            String allTab = allEmployeeMapForNameandDescription.get(entry.getKey());
            String deptTab = entry.getValue();
            if(allTab != null && deptTab != null && allTab.equals(deptTab)){
                chkcount = chkcount + 1;
            }
        }

		assertTrue(chkcount == 125);		
		
	}
	
	public void validateProperDepartments(){
													
		assertTrue(departmentcount == 125);		
	}
}
