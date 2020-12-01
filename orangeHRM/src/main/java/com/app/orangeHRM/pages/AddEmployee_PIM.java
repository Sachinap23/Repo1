package com.app.orangeHRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.orangeHRM.Utilities.Utility;
import com.app.orangeHRM.basepage.BasePage;

public class AddEmployee_PIM extends BasePage {
	
	public AddEmployee_PIM(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='firstName']") private WebElement firstNameTextBox;
	@FindBy(xpath="//input[@id='lastName']") private WebElement lastNameTextBox;
	@FindBy(xpath="//input[@id='chkLogin']") private WebElement checkbox;
	@FindBy(xpath="//input[@id='user_name']") private WebElement userNameTextBox;
	@FindBy(xpath="//input[@id='user_password']") private WebElement passwordNameTextBox;
	@FindBy(xpath="//input[@id='re_password']") private WebElement rePaswordNameTextBox;
	@FindBy(xpath="//input[@id='btnSave']") private WebElement save_saveBTN;
	
	
	public void setFirstName(String fn) {
		Utility.WaitForWebElement(driver, firstNameTextBox, 5);
		firstNameTextBox.sendKeys(fn);
	}
	public void setlastName(String ln) {
		Utility.WaitForWebElement(driver, lastNameTextBox, 5);
		lastNameTextBox.sendKeys(ln);
	}
	public void clickCheckBox() {
		checkbox.click();
	}
	public void setusername(String un) {
		Utility.WaitForWebElement(driver, userNameTextBox, 5);
		userNameTextBox.sendKeys(un);
	}
	public void setPassword(String pw) {
		Utility.WaitForWebElement(driver, passwordNameTextBox, 5);
		passwordNameTextBox.sendKeys(pw);
	}
	public void setrePassword(String rpw) {
		Utility.WaitForWebElement(driver, rePaswordNameTextBox, 5);
		rePaswordNameTextBox.sendKeys(rpw);
	}
	public void clickSaveBTN() {
		save_saveBTN.click();
	}
	
	

}
