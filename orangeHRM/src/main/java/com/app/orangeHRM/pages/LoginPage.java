package com.app.orangeHRM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="txtUsername")
	private WebElement unOHRM;
	
	@FindBy(id="txtPassword")
	private WebElement pwOHRM;
	
	@FindBy(id="btnLogin")
	private WebElement loginBTN;
	
	public void setUserName(String UN) {
	unOHRM.sendKeys(UN);
	}
	
	public void setPassword(String PW) {
	pwOHRM.sendKeys(PW);
	}
	
	public void enterlogin() {
	loginBTN.click();
	}
	public void Login(String UN,String PW) {
		unOHRM.sendKeys(UN);
		pwOHRM.sendKeys(PW);
		loginBTN.click();
	}
		
}
