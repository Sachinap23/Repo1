package com.app.orangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.app.orangeHRM.Utilities.Utility;
import com.app.orangeHRM.basepage.BasePage;

public class PersonalDetails_myInfo extends BasePage {
	Utility util=new Utility(driver);
	public PersonalDetails_myInfo(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//input[@id='btnSave']") private WebElement editBTN;
	@FindBy(xpath="//input[@id='personal_optGender_1']") private WebElement genderBTN;
	//@FindBy(xpath="//select[@id='personal_cmbNation']") private WebElement nationalityBTN;
	
	public static final By nationalityBTN =By.xpath("//select[@id='personal_cmbNation']");
	@FindBy(xpath="//input[@id='personal_DOB']") private WebElement dateOfBirthBTN;
	@FindBy(xpath="//a[contains(text(),'11')]") private WebElement selectdateOfBirthBTN;
	
	public void clickEditBTN() {
		editBTN.click();
	}
	public void clickGenderBTN() {
		genderBTN.click();
	}
	public void clickNationalityBTN() {
		//nationalityBTN.click();
	 Utility.WaitForWebElement(driver, nationalityBTN, 20);
	 WebElement list = driver.findElement(nationalityBTN);
	 Select sel=new Select(list);
	 sel.selectByValue("Indian");
		
	}
	public void clickNationalityBTN1(By locator,String expectedvalue) {
		//nationalityBTN.click();
	 Utility.WaitForWebElement(driver, nationalityBTN, 15);
	 util.dropDownSelectByValue(nationalityBTN, expectedvalue);
		
	}

	
	  public void clickDateOfBirthBTN(String datevalue) {
	  dateOfBirthBTN.click();
	  util.selectDateFromCalendar(BasePage.allDates, datevalue);
	  
	  }
	 
	public void clickDateOfBirthBTN1() {
		dateOfBirthBTN.click();
		selectdateOfBirthBTN.click();
	
		
	}
	


}
