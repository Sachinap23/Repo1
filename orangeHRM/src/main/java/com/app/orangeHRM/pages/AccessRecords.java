package com.app.orangeHRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.orangeHRM.Utilities.Utility;
import com.app.orangeHRM.basepage.BasePage;

public class AccessRecords extends BasePage {
	
	public AccessRecords(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//input[@id='confirm_password']") private WebElement verifyPasswordTextBox;
	@FindBy(xpath="//body/div[@id='wrapper']/div[@id='content']/div[1]/div[2]/form[1]/div[1]/div[1]") private WebElement verifyBTN;
	
	public void setVerifyPassword(String vpw) {
		Utility.WaitForWebElement(driver, verifyPasswordTextBox, 5);
		verifyPasswordTextBox.sendKeys(vpw);
	}
	public void clickVerifyBTN() {
		verifyBTN.click();
	}
	
	
	
	

}
