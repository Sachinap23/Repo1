package com.app.orangeHRM.testscripts;

import org.testng.annotations.Test;


import com.app.orangeHRM.generics.BaseTest;
import com.app.orangeHRM.generics.Excel;
import com.app.orangeHRM.pages.AccessRecords;
import com.app.orangeHRM.pages.LoginPage;

public class AccessRecord_Test extends BaseTest {
	
	@Test
	public void testAccessRecords() {
		String vpw = Excel.getData(XL_PATH, "CreateUser", 1, 4);
		
		LoginPage lp=new LoginPage(driver);
		lp.Login(UN, PW);
		
		AccessRecords acc=new AccessRecords(driver);
		acc.goTo_Maintainance();
		acc.setVerifyPassword(vpw);
		acc.clickVerifyBTN();
		
	}

}
