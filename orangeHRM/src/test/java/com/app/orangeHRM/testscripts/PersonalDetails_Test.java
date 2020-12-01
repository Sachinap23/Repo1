package com.app.orangeHRM.testscripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.app.orangeHRM.generics.BaseTest;
import com.app.orangeHRM.pages.LoginPage;
import com.app.orangeHRM.pages.PersonalDetails_myInfo;

public class PersonalDetails_Test extends BaseTest{
	
	private By locator;

	@Test
	public void testPersonalDetails() {
	
		LoginPage lp=new LoginPage(driver);
		lp.Login(UN, PW);
		
		PersonalDetails_myInfo pd=new PersonalDetails_myInfo(driver);
		pd.goTo_MyInfo();
		pd.clickEditBTN();
		pd.clickGenderBTN();
		pd.clickNationalityBTN1(locator, expectedvalue);
		pd.clickDateOfBirthBTN1();

 }
}
