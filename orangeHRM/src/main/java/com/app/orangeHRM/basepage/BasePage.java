package com.app.orangeHRM.basepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.orangeHRM.Utilities.Utility;

public class BasePage {
	public WebDriver driver;
	Utility util=new Utility(driver);
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public static final By allDates=By.xpath("//input[@id='personal_DOB']");
	
	//main menu's
	@FindBy(xpath="//b[contains(text(),'Admin')]") private WebElement adminlink;
	@FindBy(xpath="//b[contains(text(),'PIM')]") private WebElement maimMenu_pim;
	//public static final By mainMenu_Pim_link =By.xpath("//b[contains(text(),'PIM')]");
	@FindBy(xpath="//b[contains(text(),'My Info')]") private WebElement myInfolink;
	@FindBy(xpath="//b[contains(text(),'Maintenance')]") private WebElement maintainancelink;
	
	//submenu's
	@FindBy(xpath="//a[@id='menu_pim_addEmployee']") WebElement PIM_addEmployee;
	//public static final By addEmployeeBTN=By.xpath("//a[@id='menu_pim_addEmployee']");
	@FindBy(xpath="//a[@id='menu_pim_viewEmployeeList']") WebElement Employeelistlink;
	@FindBy(xpath="//a[@id='menu_maintenance_accessEmployeeData']") WebElement accessRecords;
	
	
	public void goTo_submenu_PIM_addEmployee() {
		Utility.WaitForWebElement(driver, maimMenu_pim, 20);
		Actions action=new Actions(driver);
		action.moveToElement(maimMenu_pim).build().perform();
		PIM_addEmployee.click();
	}
	
	public void goTo_submenu_PIM_Employeelist() {
		Utility.WaitForWebElement(driver, maimMenu_pim, 15);
		Actions action=new Actions(driver);
		action.moveToElement(maimMenu_pim).build().perform();
		Employeelistlink.click();
	}
	
	public void goTo_Maintainance() {
		Utility.WaitForWebElement(driver, maintainancelink, 15);
		Actions action=new Actions(driver);
		action.moveToElement(maintainancelink).build().perform();
		accessRecords.click();
		
	}
	public void goTo_MyInfo() {
		Utility.WaitForWebElement(driver, myInfolink, 15);
		myInfolink.click();
		
	}


}
